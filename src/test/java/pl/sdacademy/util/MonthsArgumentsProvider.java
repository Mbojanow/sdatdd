package pl.sdacademy.util;

import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MonthsArgumentsProvider implements ArgumentsProvider {
  @Override
  public Stream<Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
    return Stream.of(
        Arguments.of(Month.JANUARY),
        Arguments.of(Month.MARCH),
        Arguments.of(Month.MAY),
        Arguments.of(Month.JULY),
        Arguments.of(Month.AUGUST),
        Arguments.of(Month.OCTOBER),
        Arguments.of(Month.DECEMBER)
    );
  }
}
