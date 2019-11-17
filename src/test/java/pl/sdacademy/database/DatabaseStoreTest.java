package pl.sdacademy.database;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

  private DatabaseStore databaseStore;
  private static DatabaseConnection databaseConnection;

  private static int testNum = 1;

  @BeforeAll
  static void setUpTestCase() {
    databaseConnection = new DatabaseConnection();
    databaseConnection.open();
  }

  @AfterAll
  static void tearDownTestCase() {
    databaseConnection.close();
  }

  @BeforeEach
  void setUp() {
    databaseStore = new DatabaseStore(databaseConnection);
    System.out.println("Starting next test number " + testNum++);
  }

  @AfterEach
  void tearDown() {
    databaseStore.clean();
    if (!databaseConnection.isOpened()) {
      databaseConnection.open();
    }
  }

  @Test
  @DisplayName("This is so new random test name")
  void shouldAddSingleDataToDatabaseStore() {
    //given
    final String valueToInsert = "val";

    //when
    databaseStore.addData(valueToInsert);

    //then
    final List<String> actualData = databaseStore.getData();
    final List<String> expectedValue = Collections.singletonList(valueToInsert);
    assertIterableEquals(expectedValue, actualData);
  }

  @Disabled
  @Test
  void shouldMultipleValuesToDatabaseStore() {
    // given
    final String valueA = "va";
    final String valueB = "vb";
    //final List<String> expectedValues = Arrays.asList(valueA, valueB);

    //when
    databaseStore.addData(valueB, valueA);

    //then
    //assertIterableEquals(expectedValues, databaseStore.getData());
    final List<String> data = databaseStore.getData();
    assertTrue(data.contains(valueA));
    assertTrue(data.contains(valueB));
    assertEquals(2, data.size());
  }

  @Test
  void shouldAddNoData() {
    //given - puste
    //when
    databaseStore.addData();

    assertNotNull(databaseStore.getData());
    assertEquals(0, databaseStore.getData().size());
  }

  @Test
  void shouldRemoveDataThatExistsInDatabase() {
    //given
    final String element = "someElement";
    databaseStore.addData(element);

    // when
    final List<String> actualDatabaseContent = databaseStore.removeData(element);

    // then
    assertNotNull(actualDatabaseContent);
    // tez mozna uzyc assertEquals
    assertTrue(actualDatabaseContent.isEmpty());
  }

  @Test
  void shouldThrowWhenAddingDataWithClosedConnection() {
    // given
    databaseConnection.close();

    //then
    assertThatThrownBy(() -> databaseStore.addData())
        .hasMessageContaining("not opened")
        .hasNoCause();
  }

  @Test
  void shouldThrowWhenRemovingDataWithClosedConnection() {
    databaseConnection.close();

    assertThatExceptionOfType(DatabaseStoreException.class)
        .isThrownBy(() -> databaseStore.removeData())
        .withMessageContaining("not opened")
        .withCause(null);
  }

  // DOPISAć resztę testów dla removeData
}