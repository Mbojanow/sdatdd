package pl.sdacademy.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerUtilsTest {

  @DisplayName("My custom display name")
  @ParameterizedTest
  @ValueSource(doubles = {1.1, 2.1, 91.2})
  void someTest(final double arg) {
    System.out.println(arg);
  }
}