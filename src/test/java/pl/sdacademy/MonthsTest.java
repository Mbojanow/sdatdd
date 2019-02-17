package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Month;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class MonthsTest {

  @ParameterizedTest
  @ArgumentsSource(MonthsArgumentsSource.class)
  void shouldFindMonthWith31Days(final Month month) {
    assertThat(Months.has31Days(month)).isTrue();
  }
}