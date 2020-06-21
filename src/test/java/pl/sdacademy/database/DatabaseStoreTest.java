package pl.sdacademy.database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DatabaseStoreTest {

  private DatabaseStore databaseStore;
  private static DatabaseConnection databaseConnection;

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
  }

  @Test
  void shouldAddData() {
    // given
    String dataA = "Hello";
    String dataB = "From SDA";

    // when
    databaseStore.addData(dataA, dataB);

    // then
    List<String> actualData = databaseStore.getData();
    assertTrue(actualData.contains(dataA));
    assertTrue(actualData.contains(dataB));
  }

  @Test
  void shouldRemoveData() {
    // given
    String dataA = "Hello";
    String dataB = "From SDA";
    String dataC = "otherData";
    databaseStore.addData(dataA, dataB, dataC);

    List<String> actualData = databaseStore.removeData(dataA, dataB);

//    assertTrue(actualData.contains(dataC));
//    assertEquals(1, actualData.size());
    assertIterableEquals(List.of(dataC), actualData);
  }

  @DisplayName("Should not remove non existing data from database")
  @Test
  void shouldNotRemoveDataWhenItDoesNotExistInTheDatabase() {
    String dataA = "asdwqe";
    databaseStore.addData(dataA);

    List<String> actualData = databaseStore.removeData("otehrData");

    assertIterableEquals(List.of(dataA), actualData);
  }



















  @Test
  void playingWithList() {
    // x = [A, B, C, D, E, F];  x[1];
    // List<Integer>
    // List<Double>
    // List<String>
    // List<Integer> integers = new ArrayList<Integer>(); // poniezej skrócony

    // [ ]
    List<Integer> integers = new ArrayList<>();

    // [ 3 ]
    integers.add(3);

    // [ 3, 5]
    integers.add(5);

    System.out.println(integers.get(0));

    for (int idx = 0; idx < integers.size(); idx++) {
      System.out.println(integers.get(idx));
    }
  }

}