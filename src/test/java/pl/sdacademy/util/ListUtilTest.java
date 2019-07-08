package pl.sdacademy.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void shouldDoubleValues() {
    final List<Integer> valuesToDouble = Arrays.asList(3, 5, 4);

    final List<Integer> doubledValues = ListUtil.doubleValues(valuesToDouble);

    assertIterableEquals(Arrays.asList(6, 10, 8), doubledValues);
    assertNotSame(valuesToDouble, doubledValues);
  }

  @Test
  void shouldDoubleInputValues() {
    final List<Integer> valuesToDouble = Arrays.asList(3, 5, 4);

    final List<Integer> doubledValues = ListUtil.doubleInputValue(valuesToDouble);

    assertIterableEquals(Arrays.asList(6, 10, 8), doubledValues);
    assertSame(valuesToDouble, doubledValues);
  }
}