package pl.sdacademy.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}