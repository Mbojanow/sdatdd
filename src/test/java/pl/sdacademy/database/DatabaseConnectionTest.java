package pl.sdacademy.database;

import static org.assertj.core.api.Assertions.assertThat;
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
  void shouldThrowDatabaseConnectionExceptionWhenOpeningOpenConnection() {
    databaseConnection.open();

    final Throwable exp = assertThrows(DatabaseConnectionException.class,
        () -> databaseConnection.open());

    assertThat(exp.getMessage()).isEqualTo("DatabaseStore connection is already opened");
  }
}