package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import jdk.jfr.BooleanFlag;

class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @BeforeEach
  void setUp() {
    fibonacciSeries = new FibonacciSeries();
  }

  @ParameterizedTest
  @ArgumentsSource(FibonacciArgumentsProvider.class)
  void shouldComputeFibonacciSeriesValue(final int index, final long expectedValue) {
    final Long computedValue = fibonacciSeries.compute(index);

    assertThat(computedValue).isEqualTo(expectedValue);
  }
}