package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.user.Person;

class PersonServiceTest {

  private PersonRepository personRepository;
  private PersonService personService;

  @BeforeEach
  void setUp() {
    personRepository = new PersonRepository();
    personService = new PersonService(personRepository);
  }

  @Test
  void shouldGetPersonWithEmailThatExistsInRepository() {
    final String searchedEmail = "test2@gmail.com";

    final Person person = personService.getByEmail(searchedEmail);

    assertThat(person.getEmail()).isEqualTo(searchedEmail);
  }

  @Test
  void shouldThrowExceptionWhenGetByNonExistingEmail() {
    final String searchedEmail = "emailThatNOtExists@gmail.com";

    assertThrows(PersonActionException.class,
        () ->personService.getByEmail(searchedEmail));
  }

  @Test
  void shouldFindByExistingEmail() {
    final String searchedEmail = "test2@gmail.com";

    final Optional<Person> person = personService.findByEmail(searchedEmail);

    assertThat(person).isPresent();
    assertThat(person.get().getEmail()).isEqualTo(searchedEmail);
  }

  @Test
  void shouldGetEmptyOptionalWhenFindByNonExistingEmail() {
    final String searchedEmail = "IDoNOtExist@gmail.com";

    final Optional<Person> person = personService.findByEmail(searchedEmail);

    assertThat(person).isEmpty();
  }
}