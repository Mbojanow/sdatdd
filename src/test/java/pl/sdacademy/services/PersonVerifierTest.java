package pl.sdacademy.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
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
  private EmailVerifier emailVerifier;

  @Mock
  private NameVerifier nameVerifier;

  @Mock
  private SurnameVerifier surnameVerifier;

  @InjectMocks
  private PersonVerifier personVerifier;

  @Test
  void shouldFailEmailVerification() throws VerificationException {
    final Person person = new Person("Adam",
        "Nowak",
        "adamn@gmail.com",
        -5);

    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(false);

    assertThrows(VerificationException.class, () -> personVerifier.isValid(person));
    verify(emailVerifier).isEmailValid(person.getEmail());
    verifyZeroInteractions(nameVerifier, surnameVerifier);
  }

  @Test
  void shouldFailNameVerification() {
    final Person person = new Person("Adam",
        "Nowak",
        "adamn@gmail.com",
        -5);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(false);

    assertThrows(VerificationException.class, () -> personVerifier.isValid(person));
    verify(nameVerifier).isNameValid(person.getFullName());
    verify(emailVerifier).isEmailValid(person.getEmail());
    verifyZeroInteractions(surnameVerifier);
  }

  @Test
  void shouldFailSurnameVerification() {
    final Person person = new Person("Adam",
        "Nowak",
        "adamn@gmail.com",
        -5);

    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(any())).thenReturn(false);

    assertThrows(VerificationException.class, () -> personVerifier.isValid(person));
    verify(nameVerifier).isNameValid(person.getFullName());
    verify(emailVerifier).isEmailValid(person.getEmail());
    verify(surnameVerifier).isValid(person.getLastName());
  }
}