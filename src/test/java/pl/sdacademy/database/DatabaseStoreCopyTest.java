package pl.sdacademy.database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreCopyTest {

  @Mock
  private DatabaseConnection databaseConnection;

  @InjectMocks
  private DatabaseStoreCopy databaseStoreCopy;

  @Test
  void shouldOpenConnectionAndAddData() {
    final String data = "someDataToAdd";
    final int[] counter = {0};
    when(databaseConnection.isOpened()).thenAnswer(invocationOnMock -> {
      if (counter[0] == 0) {
        counter[0]++;
        return false;
      }
      return true;
    });


    doNothing().when(databaseConnection).open();

    databaseStoreCopy.addData(data);

    assertThat(databaseStoreCopy.getData()).containsExactlyInAnyOrder(data);
  }

}