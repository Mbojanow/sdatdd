package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void shouldDoubleValues() {
    final List<Integer> values = List.of(1, 2, 5);

    final List<Integer> actualResult = ListUtil.doubleValues(values);

    assertNotSame(values, actualResult);
    assertListContains(actualResult, 3, 2, 4, 10);
  }

  private void assertListContains(final List<Integer> actualResult,
                                  final int expectedSize,
                                  final int ...expectedValues) {
    for (int idx = 0; idx < expectedValues.length; idx++) {
      assertTrue(actualResult.contains(expectedValues[idx]));
    }
    assertEquals(expectedSize, actualResult.size());
  }

  @Test
  void shouldDoubleInputValues() {
    final List<Integer> values = new ArrayList<>();
    values.add(1);
    values.add(2);
    values.add(5);

    final List<Integer> actualResult = ListUtil.doubleInputValue(values);

    assertSame(values, actualResult);
    assertListContains(actualResult, 3, 2, 4, 10);
  }

}