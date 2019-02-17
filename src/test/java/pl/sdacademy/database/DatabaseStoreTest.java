package pl.sdacademy.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseStoreTest {

  private static DatabaseConnection databaseConnection;
  private static DatabaseStore databaseStore;

  @BeforeAll
  static void setUpTestCase() {
    databaseConnection = new DatabaseConnection();
    databaseConnection.open();
  }

  @BeforeEach
  void setUp() {
    databaseStore = new DatabaseStore(databaseConnection);
  }

  @AfterEach
  void tearDown() {
    databaseStore.clear();
  }

  @AfterAll
  static void tearDownTestCase() throws InterruptedException {
    databaseConnection.close();
  }

  @Test
  @DisplayName("Should Get Filtered Valid Data When Duplicated Values Are Inserted")
  void shouldInsertValidDataIntoDatabaseStore() {
    final String value1 = "VAL1";
    final String value2 = "VAL2";

    databaseStore.addData(value1, value2, value1);
    final Set<String> retrievedData = databaseStore.getData();

    assertTrue(retrievedData.contains(value1));
    assertTrue(retrievedData.contains(value2));
    assertEquals(2, retrievedData.size());
  }

  @Test
  @Disabled
  void shouldNotBeRun() {
    System.out.println("This should not be visible on the screen");
  }
}