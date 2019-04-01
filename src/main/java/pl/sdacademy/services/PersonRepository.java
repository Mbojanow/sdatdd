package pl.sdacademy.services;

import pl.sdacademy.user.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository {

    private List<Person> personList = new ArrayList<>();

    public PersonRepository() {
        personList = Arrays.asList(
                new Person("fn", "ln", "test1@gmail.com", 21),
                new Person("fn2", "ln2", "test2@gmail.com", 41));
    }

    public PersonRepository(final List<Person> persons) {
        this.personList = persons;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Person> getPersonsWithPolishEmail() {
        return personList.stream()
                .filter(person -> person.getEmail().contains(".pl"))
                .collect(Collectors.toList());
    }
}

