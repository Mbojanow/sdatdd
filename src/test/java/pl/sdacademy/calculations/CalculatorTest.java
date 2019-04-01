package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.DivisionByZeroException;

class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    System.out.println("BEFORE EACH");
    calculator = new Calculator();
  }

  @AfterEach
  void tearDown() {
    System.out.println("AFTER EACH");
  }

  @BeforeAll
  static void setUpTestCase() {
    System.out.println("BEFORE ALL");
  }

  @AfterAll
  static void tearDownTestCase() {
    System.out.println("AFTER ALL");
  }

  @Test
  void shouldAddTwoNumbers() {
    //given
    final Double val1 = 3.2;
    final Double val2 = 2.8;

    //when
    final Double actualSum = calculator.add(val1, val2);

    //then
    assertEquals(new Double(6.0), actualSum);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    final Double val1 = 2.0;
    final Double val2 = 3.0;

    final Double multiplicationResult = calculator.multiply(val1, val2);

    assertEquals(new Double(6.0), multiplicationResult);
  }

  @Test
  void shouldSubtractTwoNumbers() {
    final Double val1 = 2.5;
    final Double val2 = 3.8;

    final Double result = calculator.subtract(2.5, 3.8);

    assertEquals(new Double(-1.3), result, 0.1);
  }

  @Test
  void shouldFailAndDisplayMessage() {
    assertEquals(1, 2, "SDA CustomMessage");
  }

  @Test
  void shouldThrowExceptionWhenDividingByZero() {
    try {
      calculator.divide(5.0, 0.0);
      fail("Exception not thrown");
    } catch(final DivisionByZeroException exp) {
      assertThat(exp.getMessage()).isEqualTo("Cannot divide by 0!");
      assertThat(exp.getCause()).isNull();
    }
  }
}