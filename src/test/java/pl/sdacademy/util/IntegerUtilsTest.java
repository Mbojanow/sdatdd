package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerUtilsTest {

  private IntegerUtils integerUtils;

  @BeforeEach
  void setUp() {
    integerUtils = new IntegerUtils();
  }

  @Test
  void shouldFilterDigits() {
    final int toFilter = 12345;
    final List<Integer> filters = List.of(2, 4);

    final List<Integer> filteredValues = integerUtils.filter(toFilter, filters);

    //() -> asercja - implementacja interfejsu funkcjonalnego Executable
    assertAll(
        () -> assertNotNull(filteredValues),
        () -> assertEquals(3, filteredValues.size()),
        () -> assertTrue(filteredValues.contains(1)),
        () -> assertTrue(filteredValues.contains(3)),
        () -> assertTrue(filteredValues.contains(5))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThan() {
    final int toFilter = 12543;
    final int lowerBound = 3;

    final List<Integer> actualValues = integerUtils.filterDigitsGreaterThan(toFilter, lowerBound);

    assertThat(actualValues).isNotNull()
        .hasSize(2)
        .contains(5, 4);
  }

  @Test
  void shouldGetLastEvenDigitWhenEvenDigitExists() {
    final int number = 12345;

    final Optional<Integer> lastEvenDigit = integerUtils.getLastEvenDigit(number);

    assertThat(lastEvenDigit)
        .isPresent()
        .hasValue(4);
  }

  @Test
  void shouldNotGetEvenDigitWhenNoneExists() {
    final int number = 135;

    final Optional<Integer> lastEvenDigit = integerUtils.getLastEvenDigit(number);

    assertThat(lastEvenDigit).isEmpty();//.isNotPresent();
  }
}