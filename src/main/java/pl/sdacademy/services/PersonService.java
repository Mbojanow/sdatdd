package pl.sdacademy.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.sdacademy.exceptions.PersonActionException;
import pl.sdacademy.user.Person;

import java.util.Optional;

//@AllArgsConstructor
@RequiredArgsConstructor // bierze tylko final do konstruktora
public class PersonService {

    private final PersonRepository personRepository;

//    public PersonService(final PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    public Person getByEmail(final String email) {
        return personRepository.getPersonList().stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst().orElseThrow(() -> new PersonActionException("Failed to get person by email"));
    }

    public Optional<Person> findByEmail(final String email) {
        return personRepository.getPersonList().stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst();
    }
}
