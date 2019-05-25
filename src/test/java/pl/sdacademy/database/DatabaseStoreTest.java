package pl.sdacademy.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

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

  @BeforeEach
  void setUp() {
    databaseStore = new DatabaseStore(databaseConnection);
    System.out.println("Starting next test");
  }

  @AfterEach
  void tearDown() {
    databaseStore.clean();
  }

  @AfterAll
  static void tearDownTestCase() {
    databaseConnection.close();
  }

  @DisplayName("Should Add Data Custom Name")
  @Test
  void shouldAddData() {
    final String data = "someData";

    databaseStore.addData(data);

    assertIterableEquals(Collections.singletonList(data), databaseStore.getData());
  }

  @Disabled
  @Test
  void shouldRemoveDataFromDatabaseStore() {
    final String data1 = "d1";
    final String data2 = "d2";
    final String data3 = "d3";
    databaseStore.addData(data1, data2, data3);

    databaseStore.removeData(data1, data2);

    assertIterableEquals(Collections.singletonList(data3), databaseStore.getData());
  }
}