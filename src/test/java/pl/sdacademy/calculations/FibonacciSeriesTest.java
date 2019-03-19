package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @BeforeEach
  void setUp() {
    fibonacciSeries = new FibonacciSeries();
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0})
  void shouldThrowExceptionWhenProvidingNonPositiveIndex(final int index) {
    final Throwable thrownException = assertThrows(IllegalArgumentException.class,
        () -> fibonacciSeries.compute(index));
    assertThat(thrownException.getMessage()).isEqualTo("Index has to be positive");
  }
}