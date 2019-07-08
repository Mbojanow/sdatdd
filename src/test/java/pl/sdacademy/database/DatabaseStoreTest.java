package pl.sdacademy.database;

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

class DatabaseStoreTest {

  private static DatabaseConnection databaseConnection;
  private DatabaseStore databaseStore;

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
  // removeData - usunąć nieistniejący element
  // removeData - bez argimentow
  // addData - bez argumentow

}