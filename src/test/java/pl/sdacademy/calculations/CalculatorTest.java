package pl.sdacademy.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// klasa testowa, niepublicznal junit4 - musi byc  publiczna
class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void shouldAddTwoNumbers() {
    //given
    final double firstNum = 2.3;
    final double secondNum = 3.1;

    //when - wywołujemy metode testowa
    final Double actualResult = calculator.add(firstNum, secondNum);

    //then - asercje
    assertEquals(5.4, actualResult.doubleValue());
  }

  @Test
  void shouldSubtractTwoNumbers() {
    final double firstNumber = 2.5;
    final double secondNumber = 3.8;

    final Double actualResult = calculator.subtract(firstNumber, secondNumber);

    assertEquals(-1.3, actualResult.doubleValue(), 0.1);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    //given
    final double valA = 2.0;
    final double valB = 3.2;

    //when
    final Double actualResult = calculator.multiply(valA, valB);

    //then
    assertEquals(6.4, actualResult.doubleValue());
  }
}