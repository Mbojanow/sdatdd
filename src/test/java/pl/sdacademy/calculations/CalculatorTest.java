package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    //given
    final Double num1 = 3.1;
    final Double num2 = 2.5;

    //when
    final double actualValue = calculator.add(num1, num2);

    //then
    assertEquals(5.6, actualValue);
  }

  @Test
  void shouldSubtractCorrectly() {
    //given
    final Double num1 = 2.5;
    final Double num2 = 3.8;

    //when
    final double actualValue = calculator.subtract(num1, num2);

    //then
    assertEquals(-1.3, actualValue, 0.1);
  }

  @Test
  void shouldThrowExceptionWhenDividingWithDivisorEqualToZero() {
    final double dividend = 5.0;
    final double divisor = 0.0;

    try {
      calculator.divide(dividend, divisor);
      fail("Exception not thrown");
    } catch (final DivisionByZeroException exp) {
      assertThat(exp.getMessage()).isEqualTo("Cannot divide by 0!");
      assertThat(exp.getCause()).isNull();
    }
  }

  @Test
  void shouldAlwaysFail() {
    assertEquals(1, 2, "We should see this message");
  }

}