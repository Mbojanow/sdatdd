package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void shouldDoubleInputValuesWhenProvidedNonEmptyList() {
    final List<Integer> args = Arrays.asList(1, 5, 3, 10);

    final List<Integer> actualValue = ListUtil.doubleInputValue(args);

    assertIterableEquals(Arrays.asList(2, 10, 6, 20), actualValue);
    assertSame(args, actualValue);
  }

  @Test
  void shouldReturnEmptyListWhenProvidingEmptyList() {
    final List<Integer> actualValue = ListUtil.doubleInputValue(Collections.emptyList());

    assertIterableEquals(Collections.emptyList(), actualValue);
  }

}