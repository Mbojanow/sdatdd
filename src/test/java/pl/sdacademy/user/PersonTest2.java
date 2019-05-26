package pl.sdacademy.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import pl.sdacademy.exceptions.PersonUpdateFailedException;

class PersonTest2 {

  @ParameterizedTest
  @MethodSource("getAgeArgs")
  void shouldThrowExceptionWhenAgeIsIncorrect(final Integer age) {
    final String email = "someEmail@gmail.com";
    final Person person = new Person();

    assertThrows(PersonUpdateFailedException.class,
        () -> person.setPersonDetails(email, age));

  }

  public static Stream<Arguments> getAgeArgs() {
    return Stream.of(
        Arguments.of((Object) null),
        Arguments.of(0)
    );
  }



}