package pl.sdacademy.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    double valA = 3.4;
    double valB = 5.1;

    // when
    double result = calculator.add(valA, valB);

    // then
    assertEquals(8.5, result);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    double valA = 2.0;
    double valB = 3.2;

    double result = calculator.multiply(valA, valB);

    assertEquals(6.4, result);
  }

  @Test
  void shouldSubtractTwoNumbers() {
    double valA = 2.5;
    double valB = 3.8;

    double result = calculator.subtract(valA, valB);

    assertEquals(-1.3, result, 0.02);
  }

  // potrzeby zoabczenia jak wyglada nie domyslna wiadomość błędu

  @Disabled("Just to show how assertions are failing in Intellij")
  @Test
  void shouldAlwaysFail() {
    assertEquals(3, 4, "Porównanie nie udało się!");
  }
}