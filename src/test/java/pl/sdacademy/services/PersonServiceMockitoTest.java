package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonServiceMockitoTest {

  private static final String EXISTING_EMAIL = "hi@test.com";
  private static final Person PERSON_WITH_EXISTING_EMAIL = new Person("Adrzej", "Nowak",
      EXISTING_EMAIL, 15);

  @Mock(lenient = true) // lenient - wylacza sprawdzanie weryfikacji
  private PersonRepository personRepository;
  // = Mockito.mock(PersonRepository.class);
  //mniej wygodna alternatywa

  @InjectMocks
  private PersonService personService;
  // = new PersonService(personRepository);
  // działa ale mało wydajne podejście

  @BeforeEach
  void setUp() {
    when(personRepository.getPersonList()).thenReturn(List.of(PERSON_WITH_EXISTING_EMAIL));
  }

  @Test
  void shouldGetPersonByEmail() {
    final Person foundPerson = personService.getByEmail(EXISTING_EMAIL);

    assertThat(foundPerson).isEqualTo(PERSON_WITH_EXISTING_EMAIL);
    verify(personRepository).getPersonList();
    //verify(personRepository).getPersonsWithPolishEmail();
  }

  @Test
  void shouldFindPersonByEmail() {
    final Optional<Person> personFound = personService.findByEmail(EXISTING_EMAIL);

    assertThat(personFound).isPresent()
        .hasValue(PERSON_WITH_EXISTING_EMAIL);
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldNotFindPersonByEmail() {
    final String nonExistingEmail = "blabla@mail.com";
    when(personRepository.getPersonList()).thenReturn(List.of());
    //when(personRepository.getPersonsWithPolishEmail()).thenReturn(List.of());

    final Optional<Person> personFound = personService.findByEmail(nonExistingEmail);

    assertThat(personFound).isNotPresent();
    verify(personRepository).getPersonList();
  }

  @Test
  void dummyTest() {
    when(personRepository.getPersonsWithPolishEmail()).thenReturn(List.of());
    personRepository.getPersonsWithPolishEmail();
  }
}