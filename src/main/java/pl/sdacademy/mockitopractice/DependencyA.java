package pl.sdacademy.mockitopractice;

public class DependencyA {

  public boolean isValid(final Integer value) {
    return value % 3 == 1;
  }
}
