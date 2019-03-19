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
  void shouldThrowExceptionWhenDividingByZero() {
    try {
      calculator.divide(5.0, 0.0);
      fail("Divided by 0.0 did not throw expected exception");
    } catch(final DivisionByZeroException exp) {
      assertThat(exp.getCause()).isNull();
    }
  }
}