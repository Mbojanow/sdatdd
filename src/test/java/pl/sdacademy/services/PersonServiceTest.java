package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
//Junit4 @RunWith(MockitoJunitRunner.class)
class PersonServiceTest {

  @Mock
  private PersonRepository personRepository; // = Mockito.mock(PersonRepository.class);

  @InjectMocks
  private PersonService personService;

//  @BeforeEach
//  void whoWillNoticeThisMethodsHasDifferentNameHuh() {
//    //personRepository = new PersonRepository();
//    //personService = new PersonService(personRepository);
//  }

  @Test
  void shouldThrowExceptionWhenPersonWithGivenEmailDoesNotExist() {
    final String nonExistingEmail = "IDoNotExist@gmail.com";

    assertThatExceptionOfType(PersonActionException.class)
        .isThrownBy(() -> personService.getByEmail(nonExistingEmail))
        .withMessage("Failed to get person by email");
  }

  @Test
  void shouldGetPersonByExistingEmail() {
    final String email = "test1@gmail.com";
    when(personRepository.getPersonList()).thenReturn(Collections.singletonList(
        new Person("fn", "ln", email, 12)
    ));

    final Person foundPerson = personService.getByEmail(email);

    assertThat(foundPerson.getEmail()).isEqualTo(email);
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldFindByExistingEmail() {
    final String email = "test1@gmail.com";
    when(personRepository.getPersonList()).thenReturn(Collections.singletonList(
        new Person("fn", "ln", email, 12)
    ));

    final Optional<Person> person = personService.findByEmail(email);

    assertThat(person).isPresent()
        .get()
        .extracting(Person::getEmail)
        .isEqualTo(email);
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldNotFindByNonExistingEmail() {
    final String email = "IDoNotExist@gmail.com";
    when(personRepository.getPersonList()).thenReturn(
        Collections.singletonList(new Person("Jan", "Jankowski", "asd@gmail.com", 18))
    );

    final Optional<Person> person = personService.findByEmail(email);

    assertThat(person).isNotPresent();
    verify(personRepository).getPersonList();
  }

}