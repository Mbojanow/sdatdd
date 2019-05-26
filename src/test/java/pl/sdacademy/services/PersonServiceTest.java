package pl.sdacademy.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonActionException;

class PersonServiceTest {

  private PersonService personService;
  private PersonRepository personRepository;

  @BeforeEach
  void setUp() {
    personRepository = new PersonRepository();
    personService = new PersonService(personRepository);
  }

  @Test
  void shouldThrowExceptionWhenPersonByEmailNotFound() {
    final String nonExistingEmail = "IDoNotExist@IamAGhost";

    assertThrows(PersonActionException.class,
        () -> personService.getByEmail(nonExistingEmail));
  }

}