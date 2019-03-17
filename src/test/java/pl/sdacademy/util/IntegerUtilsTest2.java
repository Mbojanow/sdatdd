package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerUtilsTest2 {

  private IntegerUtils integerUtils;

  @BeforeEach
  void setUp() {
    integerUtils = new IntegerUtils();
  }

  @Test
  void shouldFilterDigits() {
    final int testedValue = 12345;
    final List<Integer> filters = Arrays.asList(2, 4);
    final List<Integer> expectedFilteredValues = Arrays.asList(1, 3, 5);

    final List<Integer> actualFilteredValues = integerUtils.filter(testedValue, filters);

    assertThat(actualFilteredValues)
        .isNotEmpty()
        .hasSize(expectedFilteredValues.size())
        .containsExactlyInAnyOrder(1, 5, 3);
  }

  @Test
  void shouldFilterDigitsGreaterThan() {
    final int testedValue = 12354;
    final int filter = 3;
    final List<Integer> expectedDigits = Arrays.asList(4, 5);

    final List<Integer> actualDigits = integerUtils
        .filterDigitsGreaterThan(testedValue, filter);

    assertAll(
        () -> assertFalse(actualDigits.isEmpty()),
        () -> assertEquals(expectedDigits.size(), actualDigits.size()),
        () -> assertTrue(actualDigits.contains(4)),
        () -> assertTrue(actualDigits.contains(5))
    );

    assertThat(actualDigits).isNotEmpty()
        .hasSize(expectedDigits.size())
        .containsExactlyInAnyOrder(4, 5);
  }

  @Test
  void shouldGetLastEvenDigit() {
    final int testedNumber = 12345;

    final Optional<Integer> actualDigit = integerUtils
        .getLastEvenDigit(testedNumber);

    assertThat(actualDigit).isPresent()
        .hasValue(4);
  }

  @Test
  void shouldGetEmptyOptionalWhenNoEvenDigitInTestedValue() {
    final int testedNumber = 135;

    final Optional<Integer> actualDigit = integerUtils
        .getLastEvenDigit(testedNumber);

    assertThat(actualDigit).isEmpty();
  }

}