package pl.sdacademy.util;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.DatabaseConnection;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreTest {

  // rownowazne DatabaseConnection databaseConnection
  // = Mockito.mock(DatabaseConnection.class)
  @Mock
  private DatabaseConnection databaseConnection;

  // rownoznacze z databaseStore = new DatabaseStore(databaseConnection)
  // gdzie databaseConnection jest mockiem stworzonym w linijce 18
  @InjectMocks
  private DatabaseStore databaseStore;

  @Test
  void shouldOpenAddAndClose() {
    when(databaseConnection.isOpen()).thenReturn(false);

    databaseStore.openSaveAndClose("dashuew");

    verify(databaseConnection, times(2)).isOpen();
    verify(databaseConnection).open();
    verify(databaseConnection).close();
  }

  @Test
  void shouldOpenAddAndCloseOpenedConnection() {
    final int[] index = { 0 };
    when(databaseConnection.isOpen()).thenAnswer(invocationOnMock -> {
      if(index[0] == 0) {
        index[0]++;
        return false;
      }
      return true;
    });

    databaseStore.openSaveAndClose("dashuew");

    verify(databaseConnection, times(2)).isOpen();
    verify(databaseConnection).open();
    verify(databaseConnection).close();
  }
}