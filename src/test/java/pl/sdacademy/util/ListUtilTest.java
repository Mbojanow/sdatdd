package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void shouldDoubleValuesAndDeepCopyList() {
    final List<Integer> inputElements = Arrays.asList(1, 2, 3);
    final List<Integer> expetedElements = Arrays.asList(2, 4, 6);

    final List<Integer> actualDoubledValues = ListUtil.doubleValues(inputElements);

    assertIterableEquals(expetedElements, actualDoubledValues);
    assertNotSame(inputElements, actualDoubledValues);
  }

  @Test
  void shouldDoubleValuesInPlace() {
    final List<Integer> inputElements = Arrays.asList(1, 2, 3);
    final List<Integer> expetedElements = Arrays.asList(2, 4, 6);

    final List<Integer> actualDoubledValues = ListUtil.doubleInputValue(inputElements);

    assertIterableEquals(expetedElements, actualDoubledValues);
    assertSame(inputElements, actualDoubledValues);

    System.out.println(inputElements == actualDoubledValues);

    assertAll();
  }
}