package pl.sdacademy.user;

import static java.util.Objects.isNull;

import java.util.Optional;

import pl.sdacademy.exceptions.PersonUpdateFailedException;


public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    private Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Person create(final String fn, final String ln) {
        return new Person(fn, ln);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setPersonDetails(final String email, final Integer age) {
        if (isNull(age) || age <= 0) {
            throw new PersonUpdateFailedException("Age has to be positive");
        }

        this.email = email;
        this.age = age;
    }

    public Optional<String> getPersonDetails() {
        if (isNull(email) || isNull(age)) {
            return Optional.empty();
        }

        return Optional.of(firstName + lastName + "is " + age +
                " years old and can be contacted by sending message to " + email);
    }

    public Person(final String firstName, final String lastName, final String email, final Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }
}
