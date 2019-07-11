package pl.sdacademy.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import pl.sdacademy.exceptions.PersonUpdateFailedException;
import pl.sdacademy.util.IntegerUtils;

class PersonTest2 {

  private Person person;

  @BeforeEach
  void setUp() {
    person = Person.create("Andrzej", "Andrzejewski");
    // też dobnrze
    // person = new Person();
  }

  @Test
  void shouldThrowExceptionWhenAgeIsNonPositive() {
    final Integer age = 0;

    assertThatExceptionOfType(PersonUpdateFailedException.class)
        .isThrownBy(() -> person.setPersonDetails("", age))
    .withMessageContaining("has to be positive")
    .withNoCause();

//    //wersja z assertThrows
//    final PersonUpdateFailedException exp = assertThrows(PersonUpdateFailedException.class,
//        () -> person.setPersonDetails("", age));
//    assertThat(exp).hasMessageContaining("has to be positive")
//        .hasNoCause();
  }

  @Test
  void shouldThrowExceptionWhenAgeIsNull() {
    final Integer age = null;

    assertThatExceptionOfType(PersonUpdateFailedException.class)
        .isThrownBy(() -> person.setPersonDetails("", age))
        .withMessageContaining("has to be positive")
        .withNoCause();
  }

  @ParameterizedTest
  @CsvSource({
      "0",
      "null"
  })
  void shouldThrowWhenSettingIncorrectDetails(final Integer age) {
    assertThatExceptionOfType(PersonUpdateFailedException.class)
        .isThrownBy(() -> person.setPersonDetails("", age))
        .withMessageContaining("has to be positive")
        .withNoCause();
  }


}