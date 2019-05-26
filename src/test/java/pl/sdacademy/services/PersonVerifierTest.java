package pl.sdacademy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

  private static final Person PERSON = Person.builder()
      .firstName("f")
      .age(1)
      .email("a")
      .lastName("ln")
      .build();

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
    when(ageVerifier.isAgeValid(PERSON.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(true);
    when(surnameVerifier.isValid(PERSON.getLastName())).thenReturn(true);

    personVerifier.isValid(PERSON);
  }

  @Test
  void shouldThrowExceptionWhenAgeVerificationFails() throws VerificationException {
    when(ageVerifier.isAgeValid(PERSON.getAge())).thenReturn(false);

    final Throwable exception = assertThrows(VerificationException.class,
        () -> personVerifier.isValid(PERSON));
    assertThat(exception.getMessage()).isEqualTo("Age is invalid");
    verifyZeroInteractions(nameVerifier, emailVerifier, surnameVerifier);
  }

  @Test
  void shouldThrowExceptionWhenNameVerificationFails() {
    when(ageVerifier.isAgeValid(PERSON.getAge())).thenReturn(true);
    when(emailVerifier.isEmailValid(PERSON.getEmail())).thenReturn(true);
    when(nameVerifier.isNameValid(PERSON.getFullName())).thenReturn(false);

    final Throwable exception = assertThrows(VerificationException.class,
        () -> personVerifier.isValid(PERSON));
    assertThat(exception.getMessage()).isEqualTo("Person name is invalid");
    verifyZeroInteractions(surnameVerifier);
  }


}