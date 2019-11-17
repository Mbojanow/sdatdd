package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.DivisionByZeroException;

class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void shouldAddTwoNumbers() {
    // given
    final double valueA = 5.3;
    final double valueB = 3.7;

    //when
    final Double actualResult = calculator.add(valueA, valueB);

    //then
    // rzutujemy na double bo assertEquals ma wiele przeciążęń
    assertEquals((Double)9.0, actualResult);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    final double valueA = 2.0;
    final double valueB = 3.1;

    final Double actualResult = calculator.multiply(valueA, valueB);

    assertEquals((Double)6.2, actualResult);
  }

  @Test
  void shouldSubtract() {
    final double valueA = 2.5;
    final double valueB = 3.8;

    final Double actualResult = calculator.subtract(valueA, valueB);

    assertEquals((Double)(-1.3), actualResult, 0.1);
  }

  @Test
  void shouldAlwaysFails() {
    assertEquals(1L, 5L, "Longs are not equal");
  }

  @Test
  void shouldThrowWhenDividingByZero() {
    final double valA = 5.0;
    final double divisor = 0.0;

    try {
      calculator.divide(valA, divisor);
      fail("You successfully divided by zero - not fine, fix it");
    } catch(final DivisionByZeroException exp) {
      assertThat(exp)
          .hasMessage("Cannot divide by 0!")
          .hasNoCause();
    }

  }
}