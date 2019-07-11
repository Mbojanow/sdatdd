package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegerUtilsTest {

  private IntegerUtils integerUtils;

  @BeforeEach
  void setUp() {
    integerUtils = new IntegerUtils();
  }

  @Test
  void shouldFilterNumberWithWhenFiltersApply() {
    final int toFilter = 12345;
    final List<Integer> filters = Arrays.asList(2, 4);

    final List<Integer> filtered = integerUtils.filter(toFilter, filters);

    assertAll(
        () -> assertFalse(filtered.isEmpty()),
        () -> assertEquals(3, filtered.size()),
        () -> assertTrue(filtered.contains(1)),
        () -> assertTrue(filtered.contains(3)),
        () -> assertTrue(filtered.contains(5))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThanWhenFilterApply() {
    final int toFilter = 12435;
    final int filter = 3;

    final List<Integer> filteredValues = integerUtils.filterDigitsGreaterThan(toFilter, filter);

//    assertThat(filteredValues).isNotEmpty()
//        .hasSize(2)
//        .contains(4, 5);
    assertThat(filteredValues).containsExactlyInAnyOrder(4, 5);
  }

  @Test
  void shouldGetLastEvenDigitWhenEvenDigitExistsInInputNumber() {
    final int input = 12435;

    final Optional<Integer> actualLastEvenDigit = integerUtils.getLastEvenDigit(input);

    assertThat(actualLastEvenDigit).isPresent()
        .contains(4);
  }

  @Test
  void shouldNotFindAnyEvenDigitInUnevenNumber() {
    final int input = 1357;

    final Optional<Integer> actualLastEvenDigit = integerUtils.getLastEvenDigit(input);

    assertThat(actualLastEvenDigit).isNotPresent();
  }

  @ParameterizedTest
  @MethodSource("testingArguments")
  void shouldReturnListOfDigitFromGivenNumber(final int inputToFilter, final List<Integer> expected) {
    final List<Integer> filtred = new ArrayList<>();
    final List<Integer> actualValue = integerUtils.filter(inputToFilter, filtred);
    assertEquals(expected, actualValue);
//        assertThat(actualValue)
//                .containsExactly(expected);
  }
  static Stream<Arguments> testingArguments() {
    return Stream.of(
        Arguments.of(12435, Arrays.asList(5, 3, 4, 2, 1)),
        Arguments.of(-12435, Arrays.asList(5, 3, 4, 2, 1))
    );
  }
}














