package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Month;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MonthsTest {

  @ParameterizedTest
  @EnumSource(value = Month.class, mode = EnumSource.Mode.EXCLUDE,
              names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
  void shouldHave31Days(final Month month) {
    final boolean isMonthWith31Days = Months.has31Days(month);

    assertThat(isMonthWith31Days).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = Month.class, mode = EnumSource.Mode.INCLUDE,
      names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
  void shouldNotHave31Days(final Month month) {
    final boolean isMonthWith31Days = Months.has31Days(month);

    assertThat(isMonthWith31Days).isFalse();
  }
}