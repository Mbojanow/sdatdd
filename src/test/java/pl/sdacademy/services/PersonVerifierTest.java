package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
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
    final Person person = new Person("fn", "ln", "asd@gmail.com", 15);
    when(ageVerifier.isAgeValid(person.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(person.getLastName())).thenReturn(true);

    personVerifier.isValidAndSend(person);

    verify(ageVerifier).isAgeValid(person.getAge());
    verify(emailVerifier).isEmailValid(person.getEmail());
    verify(nameVerifier).isNameValid(person.getFullName());
    verify(surnameVerifier).isValid(person.getLastName());
  }

  @Test
  void shouldThrowExceptionWhenAgeIsInvalid() throws VerificationException {
    final Person person = new Person("fn", "ln", "asd@gmail.com", 15);
    when(ageVerifier.isAgeValid(person.getAge())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class, () -> personVerifier.isValidAndSend(person));

    assertThat(exp).hasMessageContaining("Age");
    verify(ageVerifier).isAgeValid(person.getAge());
    verifyZeroInteractions(emailVerifier, nameVerifier, surnameVerifier);
  }

  @Test
  void shouldThrowExceptionWhenEmailIsInvalid() {
    final Person person = new Person("fn", "ln", "asd@gmail.com", 15);
    when(ageVerifier.isAgeValid(person.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class, () -> personVerifier.isValidAndSend(person));

    assertThat(exp).hasMessageContaining("Email");
    verify(ageVerifier).isAgeValid(person.getAge());
    verify(emailVerifier).isEmailValid(person.getEmail());
    verifyZeroInteractions(nameVerifier, surnameVerifier);
  }

  @Test
  void shouldThrowExceptionWhenNameIsInvalid() {
    final Person person = new Person("fn", "ln", "asd@gmail.com", 15);
    when(ageVerifier.isAgeValid(person.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(person.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(person.getFullName())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class, () -> personVerifier.isValidAndSend(person));

    assertThat(exp).hasMessageContaining("name");
    verify(ageVerifier).isAgeValid(person.getAge());
    verify(emailVerifier).isEmailValid(person.getEmail());
    verify(nameVerifier).isNameValid(person.getFullName());
    verifyZeroInteractions(surnameVerifier);
  }


}