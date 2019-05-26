package pl.sdacademy.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonVerifierTest {

  @Mock
  private AgeVerifier ageVerifier;

  @Mock
  private EmailVerifier emailVerifier;

  @Mock
  private NameVerifier nameVerifier;

  @Mock
  private SurnameVerifier surnameVerifier;

  @InjectMocks
  private PersonVerifier personVerifier;

  @Test
  void shouldValidatePerson() throws VerificationException {
    final Person person = Person.builder()
        .firstName("f")
        .age(1)
        .email("a")
        .lastName("ln")
        .build();
    when(ageVerifier.isAgeValid(person.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(person.getLastName())).thenReturn(true);

    personVerifier.isValid(person);
  }

  @Test
  void shouldThrowExceptionWhenAgeVerificationFails() {

  }

}