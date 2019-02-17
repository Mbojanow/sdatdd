package pl.sdacademy.database;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StoreTest {

  @Mock
  private Connection connection;

  @InjectMocks
  private Store store;

  @Test
  void shouldNotThrowExceptionWhenAddingDataToStore() {
    final String testData = "testData";
    when(connection.isOpen()).thenReturn(true);

    store.addData(testData);

    verify(connection).isOpen();
  }

  @Test
  void asd() {
    final String testData = "testData";
    when(connection.isOpen()).thenReturn(true);

    store.addData(testData);
    store.addData(testData);

    verify(connection, times(2)).isOpen();
  }
}