package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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

    final List<Integer> filteredDigits = integerUtils.filter(toFilter, filters);

    assertAll(
        () -> assertEquals(3, filteredDigits.size()),
        () -> assertTrue(filteredDigits.contains(1)),
        () -> assertTrue(filteredDigits.contains(3)),
        () -> assertTrue(filteredDigits.contains(5))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThan() {
    final int toFilter = 14325;
    final int lowerBound = 3;

    final List<Integer> filtered = integerUtils.filterDigitsGreaterThan(toFilter, lowerBound);

    assertThat(filtered)
        .isNotEmpty()
        .hasSize(2)
        .contains(4, 5);
  }

  @Test
  void shouldGetLastEvenDigit() {
    final int digitToTest = 14789;

    final Optional<Integer> lastEvenDigit = integerUtils.getLastEvenDigit(digitToTest);

    assertThat(lastEvenDigit).isPresent()
        .hasValue(8);
  }

  @Test
  void shouldNotGetLastEvenDigitWhenNonInNumber() {
    final int digitToTest = 135;

    final Optional<Integer> lastEvenDigit = integerUtils.getLastEvenDigit(digitToTest);

    assertThat(lastEvenDigit).isEmpty();
  }
}