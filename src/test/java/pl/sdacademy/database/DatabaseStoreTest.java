package pl.sdacademy.database;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.DatabaseStoreException;

class DatabaseStoreTest {

  private static DatabaseConnection databaseConnection;
  private DatabaseStore databaseStore;

  @BeforeAll
  static void setUpTestCase() {
    databaseConnection = new DatabaseConnection();
  }

  @AfterAll
  static void tearDownTestCase() {
    databaseConnection.close();
  }

  @BeforeEach
  void setUp() {
    databaseConnection.open();
    databaseStore = new DatabaseStore(databaseConnection);
    System.out.println("Starting next test");
  }

  @AfterEach
  void tearDown() {
    databaseStore.clean();
  }

  @DisplayName("Hey I am a test that has changed name")
  @Test
  void shouldAddSingleData() {
    final String valueToInsert = "NoSiema";

    databaseStore.addData(valueToInsert);

    final List<String> actualValues = databaseStore.getData();
    assertTrue(actualValues.contains(valueToInsert));
  }

  @Disabled
  @Test
  void shouldAddMultipleData() {
    final String valueToInsertA = "valA";
    final String valueToInsertB = "valB";
    final String valueToInsertC = "valC";

    databaseStore.addData(valueToInsertA, valueToInsertB, valueToInsertC);

    final List<String> actualValues = databaseStore.getData();
    assertIterableEquals(Arrays.asList(valueToInsertA, valueToInsertB, valueToInsertC),
        actualValues);
    //assertTrue(actualValues.contains(valueToInsertA));
    //assertTrue(actualValues.contains(valueToInsertB));
    //assertTrue(actualValues.contains(valueToInsertC));
  }

  @Test
  void shouldRemoveMultipleDataWhenDatabaseIsNotEmpty() {
    final String valueA = "valA";
    final String valueB = "valB";
    final String valueC = "valC";
    databaseStore.addData(valueA, valueB, valueC);

    databaseStore.removeData(valueA, valueB);

    final List<String> databaseValues = databaseStore.getData();
    assertIterableEquals(Collections.singletonList(valueC), databaseValues);
//    assertTrue(databaseValues.contains(valueC));
//    assertEquals(1, databaseValues.size());
  }

  // test dla clean - gdy w bazie jest coś
  @Test
  void shouldCleanDataInDatabase() {
    final String valA = "va";
    final String valB = "vb";
    databaseStore.addData(valA, valB);

    databaseStore.clean();

    assertThat(databaseStore.getData()).isEmpty();
  }

  // removeData - usunąć nieistniejący element
  @Test
  void shouldNotThrowWhenDeletingNonExistingElement() {
    final String value = "I do not exist I am a ghost";
    final String valA = "va";
    databaseStore.addData(valA);

    databaseStore.removeData(value);

    assertThat(databaseStore.getData()).containsExactly(valA);
  }

  // removeData - bez argimentow
  @Test
  void shouldNotThrowWhenDeletingNoArguments() {
    final String valA = "va";
    databaseStore.addData(valA);

    databaseStore.removeData();

    assertThat(databaseStore.getData()).containsExactly(valA);
  }

  // addData - bez argumentow
  @Test
  void shouldNotAddDataWhenNoArgProvided() {
    final String valA = "va";
    databaseStore.addData(valA);

    databaseStore.addData();

    assertThat(databaseStore.getData()).containsExactly(valA);
  }

  @Test
  void shouldThrowExceptionWhenAddingDataAndConnectionIsClosed() {
    //given
    final String value = "someValue";
    databaseConnection.close();

    assertThatThrownBy(() -> databaseStore.addData(value))
        .hasMessage("Connection is not opened. Cannot add data")
        .hasNoCause();
  }

  @Test
  void shouldThrowExceptionWhenRemovingDataAndConnectionIsClosed() {
    databaseConnection.close();

    assertThatExceptionOfType(DatabaseStoreException.class)
        .isThrownBy(() -> databaseStore.removeData())
        .withMessageContaining("is not opened. Cannot remove")
        .withNoCause();
  }
}