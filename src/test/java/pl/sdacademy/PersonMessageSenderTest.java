package pl.sdacademy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.CanIgnoreReturnValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.services.PersonRepository;
import pl.sdacademy.services.PersonVerifier;
import pl.sdacademy.user.Person;

@ExtendWith(MockitoExtension.class)
class PersonMessageSenderTest {

  @Mock
  private PersonRepository personRepository;

  @Mock
  private PersonVerifier personVerifier;

  @Mock
  private MessageSender messageSender;

  @InjectMocks
  private PersonMessageSender personMessageSender;

  // captor - sluzy do lapania argumentow method na mockach
  @Captor
  private ArgumentCaptor<Person> personArgumentCaptor;

  @Test
  void shouldSendMessageToExistingPerson() throws VerificationException {
    Person person = Person.create("Ala", "Alicka");
    when(personRepository.getPersonList())
        .thenReturn(List.of(person));
    doNothing().when(personVerifier).isValid(person);

    personMessageSender.sendMessage("Alicka", "Hi Ala");

    // kontretne wartosci jako argument + dowolne (np any())
    // to konkretna wartosc owrapowac w metode eq
    // lapanie wartosci -> verify, za pomoca capture()
    verify(messageSender).send(personArgumentCaptor.capture(), eq("Hi Ala"));
    // pobieramy zlapana wartosc
    final Person value = personArgumentCaptor.getValue();
    // robimy przypuszczenia co do zlapanej wartosci
    assertThat(value.getLastName()).isEqualTo("Alicka");
  }
}