package pl.sdacademy.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void shouldAddTwoNumbers() {
    // given
    double valA = 3.4;
    double valB = 5.1;
    Calculator calculator = new Calculator();

    // when
    double result = calculator.add(valA, valB);

    // then
    assertEquals(8.5, result);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    double valA = 2.0;
    double valB = 3.2;
    Calculator calculator = new Calculator();

    double result = calculator.multiply(valA, valB);

    assertEquals(6.4, result);
  }

  @Test
  void shouldSubtractTwoNumbers() {
    double valA = 2.5;
    double valB = 3.8;
    Calculator calculator = new Calculator();

    double result = calculator.subtract(valA, valB);

    assertEquals(-1.3, result, 0.02);
  }
}