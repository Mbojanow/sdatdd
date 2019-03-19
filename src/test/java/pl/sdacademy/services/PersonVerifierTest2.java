package pl.sdacademy.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonVerifierTest2 {

  @Mock
  private EmailVerifier emailVerifier;

  @Mock
  private NameVerifier nameVerifier;

  @Spy
  private SurnameVerifier surnameVerifier = new SurnameVerifier();

  @InjectMocks
  private PersonVerifier personVerifier;

  @Test
  void shouldVerifyCorrectPersonWithoutThrowing() throws VerificationException {
    final Person person = new Person("Jan", "Jankowski",
        "jan@wp.pl", 35);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(person.getLastName())).thenCallRealMethod();

    personVerifier.isValid(person);

    verify(emailVerifier).isEmailValid(person.getEmail());
    verify(nameVerifier).isNameValid(person.getFullName());
    verify(surnameVerifier).isValid(person.getLastName());
  }
}