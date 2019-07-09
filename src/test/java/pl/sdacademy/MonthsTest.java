package pl.sdacademy;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class MonthsTest {

  @ParameterizedTest
  @MethodSource("getMonthsWith31Days")
  void shouldHave31Days(final Month month) {
    //month = Month.APRIL;
    final boolean has31days = Months.has31days(month);

    assertThat(has31days).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = Month.class, names = {"FEBRUARY", "APRIL", "JUNE" ,"SEPTEMBER" , "NOVEMBER"})
  void shouldNotHave31Days(final Month month) {
    final boolean has31days = Months.has31days(month);

    assertThat(has31days).isFalse();
  }

  // adnotacje - DOWOLNA kolejność
  @ParameterizedTest
  // klucze w adnotacji - dowolna kolejność
  @EnumSource(names = {"FEBRUARY", "APRIL", "JUNE" ,"SEPTEMBER" , "NOVEMBER"}, value = Month.class,
              mode = EnumSource.Mode.EXCLUDE)
  void shouldHave31Days_version2(final Month month) {
    final boolean has31days = Months.has31days(month);

    assertThat(has31days).isTrue();
  }

  static Stream<Arguments> getMonthsWith31Days() {
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
}