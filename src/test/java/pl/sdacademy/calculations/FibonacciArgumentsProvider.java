package pl.sdacademy.calculations;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FibonacciArgumentsProvider implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
    return Stream.of(
        Arguments.of(3, 2),
        Arguments.of(5, 5),
        Arguments.of(7, 13),
        Arguments.of(9, 34),
        Arguments.of(10, 55)
    );
  }
}
