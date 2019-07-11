package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FibonacciSeriesTest {

  private final FibonacciSeries fibonacciSeries = new FibonacciSeries();

  @ParameterizedTest
  @ArgumentsSource(FibonacciArgumentsProvider.class)
  void shouldCalculateFibonacciSeries(final int index, final long expectedValue) {
    final Long result = fibonacciSeries.compute(index);

    assertThat(result).isEqualTo(expectedValue);
  }

  @Test
  void shouldThrowExceptionWhenComputingWithNonPositiveIndex() {
    final int incorrectIndex = 0;
    //nie wiadomo - Kasia

    final IllegalArgumentException exp = assertThrows(IllegalArgumentException.class,
        () -> fibonacciSeries.compute(incorrectIndex));

    assertThat(exp)
        .hasMessageContaining("has to be positive")
        .extracting(Throwable::getCause)
        .isNull();
  }

//  @Test
//  void shouldCalculateValueIndex1() {
//    final int index = 1;
//
//    final Long result = fibonacciSeries.compute(index);
//
//    assertThat(result).isEqualTo(1);
//  }
//
//  @Test
//  void shouldCalculateValueIndex5() {
//    final int index = 5;
//
//    final Long result = fibonacciSeries.compute(index);
//
//    assertThat(result).isEqualTo(5);
//  }
//
//  @Test
//  void shouldCalculateValueIndex15() {
//    final int index = 15;
//
//    final Long result = fibonacciSeries.compute(index);
//
//    assertThat(result).isEqualTo(610);
//  }

}