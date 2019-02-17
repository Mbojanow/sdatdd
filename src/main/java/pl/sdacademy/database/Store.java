package pl.sdacademy.database;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.sdacademy.exceptions.DatabaseConnectionException;

public class Store {

  private final Connection connection;
  private Set<String> savedValues = new HashSet<>();

  public Store(final Connection connection) {
    this.connection = connection;
  }

  public void addData(final String... newData) {
    if (!connection.isOpen()) {
      throw new DatabaseConnectionException("Database connection is closed");
    }
    savedValues.addAll(Stream.of(newData).collect(Collectors.toSet()));
  }
}
