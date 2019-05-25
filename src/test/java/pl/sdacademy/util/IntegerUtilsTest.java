package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
  void shouldFilterDigitsWhenProvidingNonEmptyFilters() {
    final int toFilter = 12345;
    final List<Integer> filters = Arrays.asList(2, 4);

    final List<Integer> filteredDigits = integerUtils.filter(toFilter, filters);

    assertAll(
        () -> assertTrue(!filteredDigits.isEmpty()),
        () -> assertEquals(3, filteredDigits.size()),
        () -> assertTrue(filteredDigits.contains(1)),
        () -> assertTrue(filteredDigits.contains(4)),
        () -> assertTrue(filteredDigits.contains(6))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThat() {
    final int toFilter = 124356;
    final int bound = 3;

    final List<Integer> filteredValues = integerUtils.filterDigitsGreaterThan(toFilter, bound);

    // 124356  3 -> [4, 5, 6]
    assertThat(filteredValues).isNotEmpty().hasSize(3)
        .containsExactlyInAnyOrder(4, 5, 6);
  }

  @Test
  void shouldGetLastEvenDigit() {
    final int value = 12345;

    final Optional<Integer> actualLastEvenDigit = integerUtils.getLastEvenDigit(value);

    assertThat(actualLastEvenDigit).isPresent().hasValue(4);
  }

  @Test
  void shouldGetEmptyOptionalForNumberWithoutEvenDigits() {
    final int value = 1357;

    final Optional<Integer> actualLastEvenDigit = integerUtils.getLastEvenDigit(value);

    assertThat(actualLastEvenDigit).isNotPresent();
  }

}