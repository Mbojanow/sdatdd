package pl.sdacademy.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.AfterAll;
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
  static void tearDownTestCase() throws InterruptedException {
    databaseConnection.close();
  }

  @BeforeEach
  void setUp() {
    databaseStore = new DatabaseStore(databaseConnection);
  }

  @DisplayName("Our custom test name")
  @Test
  void shouldAddData() {
    // given
    final String value1 = "Hello from course";
    final String value2 = "SDA is awesome";

    // when
    databaseStore.addData(value1, value2, value2);

    // then
    final Set<String> actualValues = databaseStore.getData();
    assertTrue(actualValues.contains(value1));
    assertTrue(actualValues.contains(value2));
    assertEquals(2, actualValues.size());
  }

  @Test
  @Disabled("Waiting for someone else to fix the test")
  void shouldRemoveData() {
    // given
    final String value1 = "Testing is not that boring";
    final String value2 = "SDA is awesome";
    databaseStore.addData(value1, value2);

    // when
    databaseStore.removeData(value1, value2);

    //then
    final Set<String> dataAfterRemove = databaseStore.getData();
    assertTrue(dataAfterRemove.isEmpty());
  }

}