package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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

  private static final Person PERSON = new Person("fn", "ln", "mail", 99);

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
  void shouldVerifyPersonSuccessfully() throws VerificationException {
    when(ageVerifier.isAgeValid(PERSON.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(surnameVerifier.isValid(PERSON.getLastName())).thenReturn(true);
    //when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(true);
    //nie dziala -> when(nameVerifier.isNameValid("asdqwe")).thenReturn(true);
    when(nameVerifier.isNameValid(any())).thenReturn(true);

    personVerifier.isValid(PERSON);

    verify(ageVerifier).isAgeValid(PERSON.getAge());
    verify(emailVerifier).isEmailValid(PERSON.getEmail());
    verify(surnameVerifier).isValid(PERSON.getLastName());
    verify(nameVerifier).isNameValid(PERSON.getFullName());
  }

  @Test
  void shouldThrowWhenAgeIsInvalid() {
    when(ageVerifier.isAgeValid(PERSON.getAge())).thenReturn(false);

    assertThatExceptionOfType(VerificationException.class)
        .isThrownBy(() -> personVerifier.isValid(PERSON))
        .withMessageContaining("Age");
    verify(ageVerifier).isAgeValid(PERSON.getAge());
    verifyZeroInteractions(emailVerifier, surnameVerifier, nameVerifier);
  }

}