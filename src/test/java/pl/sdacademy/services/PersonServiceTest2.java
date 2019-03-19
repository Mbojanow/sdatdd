package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest2 {

  // roznowazne z:
  // PersonRepository personRepository = Mockito.mock(PersonRepository.class);
  // PersonService personService = new PersonService(personRepository);
  // gdzie personRepostory jest już mockiem

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

  @Test
  void shouldGetPersonByEmail() {
    final String email = "andrzj@gmail.com";
    when(personRepository.getPersonList()).thenReturn(
        Collections.singletonList(
            new Person("Andrzej", "Andrzejewski", email, 22)
        ));

    final Person person = personService.getByEmail(email);

    assertThat(person.getEmail()).isEqualTo(email);
    verify(personRepository).getPersonList();
  }
}