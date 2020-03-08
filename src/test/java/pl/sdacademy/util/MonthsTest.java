package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import pl.sdacademy.user.Person;

class MonthsTest {

  private Months months = new Months();

  @ParameterizedTest
  @ArgumentsSource(MonthsArgumentsProvider.class)
  void shouldHave31Days(final Month month) {
    final boolean has31days = months.has31days(month);

    assertThat(has31days).isTrue();
  }

  @ParameterizedTest
  @MethodSource("getNon31DaysMonths")
  void shouldNotHave31Days(final Month month, final int someInt, final Person person) {
    final boolean has31days = months.has31days(month);

    assertThat(has31days).isFalse();
    System.out.println("This works " + someInt + " " + person.toString());
  }

  //zgodność nazw + metoda statyczna
  static Stream<Arguments> getNon31DaysMonths() {
    return Stream.of(
        Arguments.of(Month.FEBRUARY, 1, Person.create("Andrzej", "Nowak")),
        Arguments.of(Month.APRIL, 1, Person.create("Andrzej", "Nowak")),
        Arguments.of(Month.JUNE, 1, Person.create("Andrzej", "Nowak")),
        Arguments.of(Month.SEPTEMBER, 1, Person.create("Andrzej", "Nowak")),
        Arguments.of(Month.NOVEMBER, 1, Person.create("Andrzej", "Nowak"))
    );
  }

}