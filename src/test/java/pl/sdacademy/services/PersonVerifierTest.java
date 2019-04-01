package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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

  private static final Person PERSON
      = new Person("fn", "ln", "email@test.com", 21);

  @Mock
  private EmailVerifier emailVerifier;
  @Mock
  private NameVerifier nameVerifier;
  @Mock
  private SurnameVerifier surnameVerifier;

  //rownowazne z
  //personVerifier = new PersonVerifued(ageVerified, emailVerifier,
    // nameVerifier, surnameVerifier);
  @InjectMocks
  private PersonVerifier personVerifier;

  @Test
  void shouldValidatePerson() throws VerificationException {
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(PERSON.getLastName())).thenReturn(true);

    personVerifier.isValid(PERSON);
  }

  @Test
  void shouldFailToValidatePersonWhenEmailIsInvalid() throws VerificationException {
    when(emailVerifier.isEmailValid(any())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class,
        () ->personVerifier.isValid(PERSON));
    assertThat(exp.getMessage()).isEqualTo("Email is invalid");
    verify(emailVerifier).isEmailValid(PERSON.getEmail());
    verifyZeroInteractions(nameVerifier, surnameVerifier);
  }

  @Test
  void shouldFailToValidatePersonWhenNameInvalid() {
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class,
        () ->personVerifier.isValid(PERSON));
    assertThat(exp.getMessage()).isEqualTo("Person name is invalid");
  }

  @Test
  void test4() {
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(true);
    when(surnameVerifier.i**--+.*
    0036.*-
        .
    sValid(PERSON.getLastName())).thenReturn(false);

    final VerificationException exp = assertThrows(VerificationException.class,
        () ->personVerifier.isValid(PERSON));
    assertThat(exp.getMessage()).isEqualTo("Person last name is invalid");
  }

}