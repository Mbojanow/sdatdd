package pl.sdacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.sdacademy.exceptions.DatabaseConnectionException;

public class DatabaseStore {

  private DatabaseConnection databaseConnection;
  private List<String> data;

  public DatabaseStore(final DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
    data = new ArrayList<>();
  }

  public List<String> addData(final String value) {
    if (!databaseConnection.isOpen()) {
      throw new DatabaseConnectionException("Connection is closed");
    }

    if (!data.stream()
        .map(String::toLowerCase)
        .collect(Collectors.toList())
        .contains(value.toLowerCase())) {
      data.add(value);
    }
    return data;
  }
}
