package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void shouldReturnListWithSingleElement() {
    // given
    List<String> allElements = List.of("A", "B", "C");

    // when
    List<String> actualResult = ListUtil.createSingletonListWithRandomElement(allElements);

    // then
    assertTrue(actualResult.contains("A") || actualResult.contains("B") || actualResult.contains("C"));
  }

  @Test
  void shouldReturnEmptyListForEmptyList() {
    // given -> puste

    // when
    List<String> actualResult = ListUtil.createSingletonListWithRandomElement(List.of());

    assertTrue(actualResult.isEmpty());
  }

  @Test
  void shouldReturnReversedList() {
    List<String> sourceList = Arrays.asList("A", "B", "C");

    List<String> actualList = ListUtil.getReversedList(sourceList);

    assertIterableEquals(sourceList, actualList);
  }

  @Test
  void shouldReturnDoubledValues() {
    // given
  }

}