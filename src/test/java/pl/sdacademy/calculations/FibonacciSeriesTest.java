package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;

class FibonacciSeriesTest {

  private FibonacciSeries fibonacciSeries;

  @BeforeEach
  void setUp() {
    fibonacciSeries = new FibonacciSeries();
  }

  @ParameterizedTest
  @ArgumentsSource(FibonacciArgumentsProvider.class)
  void shouldCalculateFibonacciSeriesValue(final int index, final long expectedResult) {
    final Long actualValue = fibonacciSeries.compute(index);

    assertThat(actualValue).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @EnumSource(value = Month.class, names = "APRIL")
  void test(final Month month) {
    System.out.println(month);
  }

  @Test
  void shouldThrowExceptionWhenCalculatingWithNonPositiveIndex() {
    final int index = 0;

    final Throwable exception = assertThrows(IllegalArgumentException.class,
        () -> fibonacciSeries.compute(index));
    assertThat(exception.getMessage()).contains("has to be positive") ;
  }
}