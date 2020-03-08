package pl.sdacademy.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseStoreTest {

  private DatabaseStore databaseStore;
  private static DatabaseConnection databaseConnection;

  @BeforeAll
  //nazwa metody - dowolna nazwa, raz przed wszystkimi testami
  static void setUpTestCase() {
    databaseConnection = new DatabaseConnection();
    databaseConnection.open();
  }

  // kolejnosc definiowania metod - dowolna
  @AfterAll
  static void tearDownTestCase() {
    databaseConnection.close();
  }

  @BeforeEach
  void setUp() {
    databaseStore = new DatabaseStore(databaseConnection);
  }

  @AfterEach
  void tearDown() {
    System.out.println("After each test");
  }

  @DisplayName("Test should add two values to database store")
  @Test
  void shouldAddData() {
    //given - warunki początkowe
    final String valueA = "val1";
    final String valueB = "val2";
    // databaseStore = new DatabseStore(dbConnection) -> nie trzeba

    //when
    databaseStore.addData(valueA, valueB);

    // then
    final List<String> actualData = databaseStore.getData();
    assertEquals(2, actualData.size());
    assertTrue(actualData.contains(valueA));
    assertTrue(actualData.contains(valueB));
  }

  @Disabled("Test disabled. Other dev will fix that next week.")
  @Test
  void shouldNotAddDataWhenNoInputGiven() {
    //given - puste
    //when
    databaseStore.addData();

    //then
    final List<String> actualData = databaseStore.getData();
    assertTrue(actualData.isEmpty());
  }

  @Test
  void shouldRemoveExistingData() {
    final String valueA = "valA";
    final String valueB = "valB";
    databaseStore.addData(valueA, valueB);

    final List<String> actualContent = databaseStore.removeData(valueA);

    assertIterableEquals(List.of(valueB), actualContent);
  }

  @Test
  void shouldNotRemoveNonExistingData() {
    //given
    final String valueA = "valA";
    final String nonExistingData = "IdoNotExistIamAGhost";
    databaseStore.addData(valueA);

    // when
    final List<String> actualData = databaseStore.removeData(nonExistingData);

    // then
    assertIterableEquals(List.of(valueA), actualData);
  }
}