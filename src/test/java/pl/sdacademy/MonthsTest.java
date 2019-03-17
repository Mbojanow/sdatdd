package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MonthsTest {

  private Months months;

  @BeforeEach
  void setUp() {
    months = new Months();

    //Month.valueOf("JANUARY")
  }

  @ParameterizedTest
  @MethodSource("argumentsForMonthWith31Days")
  void shouldHave31Days(final Month month) {
    final boolean has31Days = months.has31days(month);

    assertThat(has31Days).isTrue();
  }

  private static Stream<Arguments> argumentsForMonthWith31Days() {
    return Stream.of(
        Arguments.of(Month.JANUARY),
        Arguments.of(Month.MARCH),
        Arguments.of(Month.MAY),
        Arguments.of(Month.JULY),
        Arguments.of(Month.AUGUST),
        Arguments.of(Month.OCTOBER),
        Arguments.of(Month.DECEMBER)
    );
  }


  @ParameterizedTest
  @ValueSource(strings = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
  void shouldNotHave31Days(final String monthName) {
    final Month month = Month.valueOf(monthName);

    final boolean doesNotHave31Days = months.has31days(month);

    assertThat(doesNotHave31Days).isFalse();
  }

  @ParameterizedTest
  @CsvSource({
      "FEBRUARY, 2",
      "APRIL, 4",
      "JUNE, 6",
      "SEPTEMBER, 9",
      "NOVEMBER, 11"})
  //@CsvSource("FEBRUARY, APRIL, JUNE, SEPTEMBER, NOVEMBER")
  void shouldNotHave31Day_2(final String monthName, final int monthIndex) {
    final Month month = Month.valueOf(monthName);

    final boolean doesNotHave31Days = months.has31days(month);

    System.out.println("Month index is " + monthIndex);
    assertThat(doesNotHave31Days).isFalse();
  }

  @ParameterizedTest
  //@CsvSource({"FEBRUARY, 2", "APRIL, 4", "JUNE, 6", "SEPTEMBER, 9", "NOVEMBER, 11"})
  @CsvFileSource(resources = "/source.csv")
  void shouldNotHave31Day_3(final String monthName, final int monthIndex) {
    final Month month = Month.valueOf(monthName);

    final boolean doesNotHave31Days = months.has31days(month);

    System.out.println("Month index is " + monthIndex);
    assertThat(doesNotHave31Days).isFalse();
  }

}