package pl.sdacademy.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
  void shouldFilterDigitsCorrectly() {
    final int numberToTest = 12345;
    final List<Integer> filters = Arrays.asList(2, 4);
    final List<Integer> expectedFilteredList = Arrays.asList(5, 3, 1);

    final List<Integer> filteredDigits = integerUtils.filter(numberToTest, filters);

    assertAll(
        () -> assertEquals(expectedFilteredList.size(), filteredDigits.size()),
        () -> assertFalse(filteredDigits.isEmpty()),
        () -> assertEquals(expectedFilteredList, filteredDigits)
    );
  }

  @Test
  void shouldGetDigitsGreaterThanProvider() {
    final int testedValue = 12345;
    final int bound = 3;

    final List<Integer> filtedredList = integerUtils.filterDigitsLowerThan(testedValue, bound);

    assertThat(filtedredList)
        .hasSize(2)
        .isNotEmpty()
        .containsExactlyInAnyOrder(4, 5);
  }

  @Test
  void shouldGetFirstEvenDigit() {
    final int testedValue = 12345;

    final Optional<Integer> retrievedValue = integerUtils.getLastEvenDigit(testedValue);

    assertThat(retrievedValue)
        .isPresent()
        .hasValue(4);
  }

}