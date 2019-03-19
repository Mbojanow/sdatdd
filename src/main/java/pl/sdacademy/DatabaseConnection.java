package pl.sdacademy;

import pl.sdacademy.exceptions.DatabaseConnectionException;

public class DatabaseConnection {

  private boolean isOpen;

  public DatabaseConnection() {
    isOpen = false;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void open() {
    if (isOpen) {
      throw new DatabaseConnectionException("Connection already opened");
    }

    isOpen = true;
  }

  public void close() {
    if (!isOpen) {
      throw new DatabaseConnectionException("Connection already closed or not opened");
    }

    isOpen = false;
  }
}
