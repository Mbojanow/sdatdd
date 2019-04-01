package pl.sdacademy.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonUpdateFailedException;

class PersonTest2 {

  @Test
  void shouldThrowExceptionWhenAgeIsNegative() {
    final Integer age = -1;
    final Person person = Person.create("Jan", "Kowalski");

    final PersonUpdateFailedException exp = assertThrows(PersonUpdateFailedException.class,
        () -> person.setPersonDetails("jk@gmail.com", age));
    assertThat(exp.getMessage()).isEqualTo("Age has to be positive");
    assertThat(exp.getCause()).isNull();

    x("s", "x");
  }

  int x(String s1, String s2) {
    return 0;
  }

}