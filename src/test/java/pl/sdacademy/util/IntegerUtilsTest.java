package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class IntegerUtilsTest {

  private IntegerUtils integerUtils = new IntegerUtils(); // zamiast @BeforeEach

  @Test
  void shouldFilterDigits() {
    int toFilter = 12345;
    List<Integer> integers = List.of(2, 4);

    List<Integer> actualResult = integerUtils.filter(toFilter, integers);

    assertAll(
        () -> assertNotNull(actualResult),
        () -> assertEquals(3, actualResult.size()),
        () -> assertTrue(actualResult.contains(1)),
        () -> assertTrue(actualResult.contains(3)),
        () -> assertTrue(actualResult.contains(5))
    );
  }

  @Test
  void shouldFilterDigitsGreaterThan() {
    int toFilter = 31587;
    int bound = 5;

    List<Integer> actualResult = integerUtils.filterDigitsGreaterThan(toFilter, bound);

    assertThat(actualResult)
        .isNotNull()
        .hasSize(2)
        .containsExactlyInAnyOrder(8, 7);
  }








}