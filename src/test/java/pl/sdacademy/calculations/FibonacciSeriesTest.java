package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @BeforeEach
  void setUp() {
    fibonacciSeries = new FibonacciSeries();
  }

  @ParameterizedTest
  @ArgumentsSource(FibonacciArgumentsProvider.class)
  void shouldCalculateFibonacciSeries(final int index, final Long expectedValue) {
    final Long calculatedValue = fibonacciSeries.compute(index);

    assertThat(calculatedValue).isEqualTo(expectedValue);
  }
}