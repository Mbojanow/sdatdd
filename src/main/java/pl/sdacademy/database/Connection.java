package pl.sdacademy.database;

public class Connection {

  private boolean isOpen;

  public void open() {
    isOpen = true;
  }

  public void close() {
    isOpen = false;
  }

  public boolean isOpen() {
    return isOpen;
  }
}
