package pl.sdacademy;

public class DatabaseConnection {

  private boolean open = false;

  public void open() throws InterruptedException {
    Thread.sleep(1000L);
    open = true;
  }

  public void close() {
    open = false;
  }

  public boolean isOpen() {
    return open;
  }
}
