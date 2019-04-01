package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @BeforeEach
  void setUp() {
    fibonacciSeries = new FibonacciSeries();
  }

  @ParameterizedTest
  @CsvSource({
      "1, 1",
      "2, 1",
      "3, 2",
      "4, 3",
      "5, 5",
      "10, 55"
  })
  void shouldComputeFibonacciValue(final int index, final long expectedValue) {
    final long actualValue = fibonacciSeries.compute(index);

    assertThat(actualValue).isEqualTo(expectedValue);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/source.csv")
  void shouldComputeFibonacciSeriesValue(final int index, final long expectedValue) {
    final long actualValue = fibonacciSeries.compute(index);

    assertThat(actualValue).isEqualTo(expectedValue);
  }

  @ParameterizedTest
  @MethodSource("getFibonacciParams")
  void shouldComputeFibonacciValueFromMethod(final int index, final long expectedValue) {
    final long actualValue = fibonacciSeries.compute(index);

    assertThat(actualValue).isEqualTo(expectedValue);
  }

  public static Stream<Arguments> getFibonacciParams() {
    return Stream.of(Arguments.of(1, 1),
        Arguments.of(10, 55));
  }

  @Test
  void shouldThrowExceptionWhenComputingValueWithNegativeIndex() {
    final int negativeIndex = -1;

    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> fibonacciSeries.compute(negativeIndex));
    assertThat(exception.getMessage()).isEqualTo("Index has to be positive");
  }
}