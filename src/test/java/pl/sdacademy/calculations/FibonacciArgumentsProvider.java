package pl.sdacademy.calculations;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FibonacciArgumentsProvider implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
    return Stream.of(
        Arguments.of(1, 1),
        Arguments.of(2, 1),
        Arguments.of(3, 2),
        Arguments.of(15, 610),
        Arguments.of(20, 6765)
    );
  }
}
