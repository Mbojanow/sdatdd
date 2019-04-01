package pl.sdacademy;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.DatabaseConnectionException;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreTest {

  @Mock
  private DatabaseConnection databaseConnection;

  @InjectMocks
  private DatabaseStore databaseStore;

//  @BeforeAll
//  static void setUpTestCase() throws InterruptedException {
//    databaseConnection = new DatabaseConnection();
//    databaseConnection.open();
//  }
//
//  @AfterAll
//  static void tearDownTestCase() {
//    databaseConnection.close();
//  }

  @BeforeEach
  void setUp() {
    when(databaseConnection.isOpen()).thenReturn(true);
  }

//  @AfterEach
//  void tearDown() {
//    verify(databaseConnection).isOpen();
//  }

  @Test
  @DisplayName("Should Add Data - out custom name")
  void shouldAddData() {
    final String data = "SDA is pretty cool";

    final List<String> actualData = databaseStore.addData(data);

    assertIterableEquals(Collections.singletonList(data), actualData);
    verify(databaseConnection).isOpen();
  }

  @Test
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

    verify(databaseConnection,
        Mockito.times(3)).isOpen();
    //assertIterableEquals(Arrays.asList(data1, data1, data2), actualData);
  }

  @Test
  void shouldNotAddDuplicatedValue() {
    final String data1 = "DATA1";
    final String data2 = "DaTa1";

    databaseStore.addData(data1);
    final List<String> actual = databaseStore.addData(data2);

    assertIterableEquals(Collections.singletonList(data1), actual);
    verify(databaseConnection, Mockito.times(2)).isOpen();
    //assertAll()
  }

  @Test
  void shouldThrowWhenAddingDataAndConnectionToDbIsClosed() {
    final String data = "asd";
    when(databaseConnection.isOpen()).thenReturn(false);

    assertThrows(DatabaseConnectionException.class,
        () -> databaseStore.addData(data));
    verify(databaseConnection).isOpen();
  }
}