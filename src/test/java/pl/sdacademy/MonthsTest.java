package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MonthsTest {

  private Months months = new Months();

  @ParameterizedTest
  @EnumSource(value = Month.class,
      names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
      mode = EnumSource.Mode.EXCLUDE)
  void shouldHave31Days(final Month month) {
    final boolean has31Days = months.has31days(month);

    assertThat(has31Days).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = Month.class, names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
  void shouldNotHave31Days(final Month month) {
    final boolean has31Days = months.has31days(month);

    assertThat(has31Days).isFalse();
  }

}