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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerUtilsTest2 {

  private IntegerUtils integerUtils;

  @BeforeEach
  void setUp() {
    integerUtils = new IntegerUtils();
  }

  @Test
  void shouldFilterValues() {
    final int testedNumber = 12345;
    final List<Integer> filters = Arrays.asList(4, 5);

    final List<Integer> filteredValues = integerUtils.filter(testedNumber, filters);

    assertAll(
        () -> assertFalse(filteredValues.isEmpty()),
        () -> assertEquals(3, filteredValues.size()),
        () -> assertTrue(filteredValues.contains(1)),
        () -> assertTrue(filteredValues.contains(2)),
        () -> assertTrue(filteredValues.contains(3))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThan() {
    final int valueToTest = 14535;
    final int bound = 3;

    final List<Integer> filteredValues = integerUtils.filterDigitsGreaterThan(valueToTest, bound);

    // 1. lista niepusta
    // 2. lista ma oczekiwany rozmiar
    // 3. lista zawiera oczekiwane elementy

    assertThat(filteredValues).isNotEmpty()
        .hasSize(3)
        .containsExactlyInAnyOrder(4, 5, 5);
  }

  @Test
  void shouldGetEvenDigit() {
    final int testValue = 12345;

    final Optional<Integer> actual = integerUtils.getFirstEvenDigit(testValue);

    //FIXME AT HOME POZ15 GROUP PLEASE OR I WILL BE SAD
    assertThat(actual).isPresent().hasValue(2);
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, 4, Integer.MIN_VALUE })
  void shouldBeEven(final int testedValue) {

    final boolean isEven = integerUtils.isEven(testedValue);

    assertThat(isEven).isTrue();
  }

  @ParameterizedTest
  @ValueSource(doubles = { 2.1, 3.2, 5.4 })
  void testThatDoesNothing(final double value) {
    System.out.println(value);
  }

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L})
  void testWithoutArgs(final int value) {
    System.out.println(value);
  }

}