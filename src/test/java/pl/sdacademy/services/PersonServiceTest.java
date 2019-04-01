package pl.sdacademy.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

  @InjectMocks
  private PersonService personService;
  @Mock
  private PersonRepository personRepository;

//  @BeforeEach
//  void setUp() {
//    personService = new PersonService(personRepository);
//  }

  @Test
  void shouldFindPersonByEmailWhenEmailExists() {
    final String searchedEmail = "test1@gmail.com";
    when(personRepository.getPersonList()).thenReturn(
        Collections.singletonList(new Person("fn",
            "ln", searchedEmail, 31)));

    final Person person = personService.getByEmail(searchedEmail);

    assertEquals(searchedEmail, person.getEmail());
    verify(personRepository).getPersonList();
  }

  @Test
  void shouldThrowExceptionWhenPersonByEmailNotFound() {
    final String searchedEmail = "test3@gmail.com";

    assertThrows(PersonActionException.class,
        () -> personService.getByEmail(searchedEmail));
  }

}