package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.user.Person;

class PersonServiceTest {

  private static final String EXISTING_EMAIL = "test1@gmail.com";
  private static final String NON_EXISTING_EMAIL = "idontexistiamaghost@test.com";

  private PersonService personService;
  private PersonRepository personRepository;

  @BeforeEach
  void setUp() {
    personRepository = new PersonRepository();
    personService = new PersonService(personRepository);
  }

  @Test
  void shouldGetPersonByExistingEmail() {
    final Person personFoundByEmail = personService.getByEmail(EXISTING_EMAIL);

    // też okej
    //assertThat(personFoundByEmail.getEmail()).isEqualTo(email);
    assertThat(personFoundByEmail).isNotNull()
        .extracting(Person::getEmail)
        .isEqualTo(EXISTING_EMAIL);
  }

  @Test
  void shouldThrowWhenPersonByEmailDoesNotExist() {
    assertThatThrownBy(() -> personService.getByEmail(NON_EXISTING_EMAIL))
        .isExactlyInstanceOf(PersonActionException.class)
        .hasMessageContaining("Failed to get person");
  }

  @Test
  void shouldFindPersonByExistingEmail() {
    final Optional<Person> person = personService.findByEmail(EXISTING_EMAIL);

    assertThat(person).isPresent()
        .get()
        .extracting(Person::getEmail)
        .isEqualTo(EXISTING_EMAIL);
  }

  @Test
  void shouldNotFindPersonByNonExistingEmail() {
    final Optional<Person> person = personService.findByEmail(NON_EXISTING_EMAIL);

    assertThat(person).isNotPresent();
  }

}