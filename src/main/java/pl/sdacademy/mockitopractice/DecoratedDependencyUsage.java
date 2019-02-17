package pl.sdacademy.mockitopractice;

public class DecoratedDependencyUsage extends DependencyUsage {

  public DecoratedDependencyUsage(final DependencyA dependencyA, final DependencyB dependencyB) {
    super(dependencyA, dependencyB);
  }

  @Override
  public void isInvalid(final Integer value) {
    System.out.println("BEFORE INVALIDATING");
    super.isInvalid(value);
    System.out.println("AFTER INVALIDATING");
  }
}
