package pl.sdacademy;

import java.util.Optional;

import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.services.PersonRepository;
import pl.sdacademy.services.PersonVerifier;
import pl.sdacademy.user.Person;

public class PersonMessageSender {

  private final PersonRepository personRepository;
  private final PersonVerifier personVerifier;
  private final MessageSender messageSender;

  public PersonMessageSender(final PersonRepository personRepository, final PersonVerifier personVerifier, final MessageSender messageSender) {
    this.personRepository = personRepository;
    this.personVerifier = personVerifier;
    this.messageSender = messageSender;
  }

  public void sendMessage(final String surname, final String text) throws VerificationException {
    final Optional<Person> personWithSurname = personRepository.getPersonList().stream()
        .filter(person -> person.getLastName().equals(surname))
        .findFirst();

    if (personWithSurname.isEmpty()) {
      throw new PersonActionException("person by surname not found");
    }

    personVerifier.isValid(personWithSurname.get());
    // 1 argument - type Person
    messageSender.send(personWithSurname.get(), text);
  }
}
