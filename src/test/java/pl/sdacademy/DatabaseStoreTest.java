package pl.sdacademy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseStoreTest {

  static private DatabaseConnection databaseConnection;
  private DatabaseStore databaseStore;

  @BeforeAll
  static void setUpTestCase() throws InterruptedException {
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
  }

  @Test
  @DisplayName("Should Add Data - out custom name")
  void shouldAddData() {
    final String data = "SDA is pretty cool";

    final List<String> actualData = databaseStore.addData(data);

    assertIterableEquals(Collections.singletonList(data), actualData);
  }

  @Test
  @Disabled
  void shouldAddDataThreeTimes() {
    final String data1 = "DATA1";
    final String data2 = "DATA2";

    databaseStore.addData(data1);
    databaseStore.addData(data1);
    final List<String> actualData = databaseStore.addData(data2);

    final List<String> expectedList = new ArrayList<>();
    expectedList.add(data1);
    //expectedList.add(data1);
    expectedList.add(data2);
    assertIterableEquals(expectedList, actualData);

    //assertIterableEquals(Arrays.asList(data1, data1, data2), actualData);
  }

  @Test
  void shouldNotAddDuplicatedValue() {
    final String data1 = "DATA1";
    final String data2 = "DaTa1";

    databaseStore.addData(data1);
    final List<String> actual = databaseStore.addData(data2);

    assertIterableEquals(Collections.singletonList(data1), actual);
    //assertAll()
  }
}