package pl.sdacademy.database;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.DatabaseConnectionException;
import pl.sdacademy.exceptions.DatabaseStoreException;

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
    if (!databaseConnection.isOpened()) {
      databaseConnection.open();
    }
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

  @Test
  void shouldThrowExceptionWhenAddingDataAndDatabaseConnectionClosed() {
    final String data = "someData";
    databaseConnection.close();

    assertThatThrownBy(() -> databaseStore.addData(data))
        .hasMessage("Connection is not opened. Cannot add data")
        .hasNoCause();
  }

  @Test
  void shouldThrowExceptionWhenRemovingDataAndDatabaseConnectionIsClosed() {
    final String data = "someData";
    databaseConnection.close();

    assertThatExceptionOfType(DatabaseStoreException.class)
        .isThrownBy(() -> databaseStore.removeData(data))
        .withMessage("Connection is not opened. Cannot remove data");


  }
}