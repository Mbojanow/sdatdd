package pl.sdacademy.mockitopractice;

public class DependencyB {

  public boolean isValid(final Integer value) {
    return value % 3 == 2;
  }
}
