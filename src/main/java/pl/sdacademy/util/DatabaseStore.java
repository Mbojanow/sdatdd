package pl.sdacademy.util;

import java.util.ArrayList;
import java.util.List;

import pl.sdacademy.DatabaseConnection;

public class DatabaseStore {

  private final DatabaseConnection databaseConnection;
  private List<String> data = new ArrayList<>();

  public DatabaseStore(final DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public void openSaveAndClose(final String value) {
    if (!databaseConnection.isOpen()) {
      databaseConnection.open();
    }

    data.add(value);

    if (databaseConnection.isOpen()) {
      databaseConnection.close();
    }
  }
}
