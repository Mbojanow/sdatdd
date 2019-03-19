package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.DatabaseConnectionException;

class DatabaseConnectionTest {

  private DatabaseConnection databaseConnection;

  @BeforeEach
  void setUp() {
    databaseConnection = new DatabaseConnection();
  }

  @Test
  void shouldThrowExceptionWhenConnectionAlreadyOpened() {
    databaseConnection.open();

    assertThatThrownBy(() -> databaseConnection.open())
        .hasMessage("Connection already opened")
        .hasNoCause();
  }

  @Test
  void shouldThrowExceptionWhenDatabaseConnectionNotOpened() {
    assertThatExceptionOfType(DatabaseConnectionException.class)
        .isThrownBy(() -> databaseConnection.close());
  }
}