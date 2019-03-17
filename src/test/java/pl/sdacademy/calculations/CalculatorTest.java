package pl.sdacademy.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator;

  @BeforeAll
  static void setUpTestCase() {
    System.out.println("set up test case");
  }

  @AfterAll
  static void tearDownTestCase() {
    System.out.println("Tear down test case");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Set up");
    calculator = new Calculator();
  }

  @AfterEach
  void tearDown() {
    System.out.println("Tear down");
  }

  @Test
  void shouldAddTwoNumber() {
    // given
    final Double value1 = 2.3;
    final Double value2 = 3.1;

    // when
    final Double actualResult = calculator.add(value1, value2);

    // then
    assertEquals(new Double(5.4), actualResult);
  }

  @Test
  void shouldMultiplyTwoNumbers() {
    // given
    final Double value1 = 2.0;
    final Double value2 = 3.0;

    // when
    final Double actualResults = calculator.multiply(value1, value2);

    // then
    assertEquals(new Double(6.0), actualResults);
  }

  @Test
  void shouldSubtractTwoNumber() {
    // given
    final Double value1 = 2.5;
    final Double value2 = 3.8;

    // when
    final Double actualResults = calculator.subtract(value1, value2);

    assertEquals(new Double(-1.3), actualResults, 0.1);
  }

}