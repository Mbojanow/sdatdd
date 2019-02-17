package pl.sdacademy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizedTestsDemo {

  @ParameterizedTest(name = "{displayName} {arguments}")
  @ValueSource(longs = {1L, 5L, 15L})
  void ourFirstParametrizedTest(final long injectedValue) {
    assertTrue(injectedValue % 2 == 1);
  }

  @ParameterizedTest
  @CsvSource(value = {"Michal, Bojanowski, 18",
                      "Ania, Z zielonego wzgorza, 99"})
  void ourFirstCsvParametrizedTest(final String name, final String surname, final int age) {
    System.out.println(String.format("%s %s %d", name, surname, age));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/source.csv", delimiter = '.')
  void ourSecondCsvParametrizedTest(final String name, final String surname, final int age) {
    System.out.println(String.format("%s %s %d", name, surname, age));
  }

  @ParameterizedTest
  @MethodSource(value = "getMethodSourceArguments")
  void ourMethodSourceTest(final String name, final long height) {
    System.out.println(name + " is " + height + " cm high");
  }

  private static Stream<Arguments> getMethodSourceArguments() {
    return Stream.of(
        Arguments.of("Kasia", 165),
        Arguments.of("Andrzej", 180),
        Arguments.of("Michal", 181)
    );
  }
}
