package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonActionException;

class PersonServiceTest {

  private PersonRepository personRepository;
  private PersonService personService;

  @BeforeEach
  void whoWillNoticeThisMethodsHasDifferentNameHuh() {
    personRepository = new PersonRepository();
    personService = new PersonService(personRepository);
  }

  @Test
  void shouldThrowExceptionWhenPersonWithGivenEmailDoesNotExist() {
    final String nonExistingEmail = "IDoNotExist@gmail.com";

    assertThatExceptionOfType(PersonActionException.class)
        .isThrownBy(() -> personService.getByEmail(nonExistingEmail))
        .withMessage("Failed to get person by email");
  }

}