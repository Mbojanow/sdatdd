package pl.sdacademy.calculations;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FibonacciArgumentsProvider implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) throws Exception {
    return Stream.of(
        Arguments.of(1, 1L),
        Arguments.of(4, 3L),
        Arguments.of(8, 21L),
        Arguments.of(12, 144L)
    );
  }
}
