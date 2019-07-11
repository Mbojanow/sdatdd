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
    final double numA = 2;
    final double numB = 3;

    //when
    final double actualResult = calculator.add(numA, numB);

    //then
    assertEquals(5, actualResult);
  }

  @Test
  void shouldSubtractTwoNumbers() {
    final double numA = 2.5;
    final double numB = 3.8;

    final double actualResult = calculator.subtract(numA, numB);

    assertEquals(-1.3, actualResult, 0.1);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    final double numA = 2.1;
    final double numB = 3.0;

    final double actualResult = calculator.multiply(numA, numB);

    assertEquals(6.3, actualResult, 0.1);
  }

  @Test
  void shouldThrowExceptionWhenDividingByZero() {
    final double numA = 5.0;
    final double numB = 0.0;

    try {
      calculator.divide(numA, numB);
      fail("Exception not thrown");
    } catch(final DivisionByZeroException exp) {
      assertThat(exp).hasMessage("Cannot divide by 0!");
      assertThat(exp).hasNoCause();
    }
  }
}