package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        () -> assertTrue(filtered.contains(2)),
        () -> assertTrue(filtered.contains(4))
    );
  }
}