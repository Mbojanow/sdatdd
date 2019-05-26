package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest3 {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

//  @BeforeEach
//  void setUp() {
//    personService = new PersonService(personRepository);
//  }

  @Test
  void shouldFindPersonByEmailGivenEmailExistsInRepository() {
    final String lookedEmail = "test@gmail.com";
    when(personRepository.getPersonList())
        .thenReturn(Collections.singletonList(
            Person.builder().email(lookedEmail).build()
        ));

    final Person person = personService.getByEmail(lookedEmail);

    assertThat(person.getEmail()).isEqualTo(lookedEmail);
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldGetPersonByEmail() {
    final String lookedEmail = "test@gmail.com";
    when(personRepository.getPersonList())
        .thenReturn(Collections.singletonList(
            Person.builder().email(lookedEmail).build()
        ));

    final Optional<Person> person = personService.findByEmail(lookedEmail);

    assertThat(person).isPresent()
        .hasValueSatisfying(p -> assertThat(p.getEmail()).isEqualTo(lookedEmail));
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldNotFindPersonByEmailWhenEmailDoesNotExist() {
    final String email = "GeraltOfRivia@email.com";
    when(personRepository.getPersonList()).thenReturn(Collections.emptyList());

    final Optional<Person> person = personService.findByEmail(email);

    assertThat(person).isNotPresent();
    verify(personRepository).getPersonList();
  }

}