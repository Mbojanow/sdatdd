package pl.sdacademy.mockitopractice;

import pl.sdacademy.exceptions.DatabaseConnectionException;

public class DependencyUsage {

  private DependencyA dependencyA;
  private DependencyB dependencyB;

  public DependencyUsage(final DependencyA dependencyA, final DependencyB dependencyB) {
    this.dependencyA = dependencyA;
    this.dependencyB = dependencyB;
  }

  public void isInvalid(final Integer value) {
    if (!dependencyA.isValid(value)) {
      throw new DatabaseConnectionException("DEPENDECY A FAILED");
    }

    if (!dependencyB.isValid(value)) {
      throw new DatabaseConnectionException("DEPENDENCY B FAILED");
    }
  }
}
