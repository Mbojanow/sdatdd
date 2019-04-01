package pl.sdacademy.services;

import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.user.Person;

public class PersonVerifier {

    private final EmailVerifier emailVerifier;
    private final NameVerifier nameVerifier;
    private final SurnameVerifier surnameVerifier;

    public PersonVerifier(final EmailVerifier emailVerifier, final NameVerifier nameVerifier, final SurnameVerifier surnameVerifier) {
        this.emailVerifier = emailVerifier;
        this.nameVerifier = nameVerifier;
        this.surnameVerifier = surnameVerifier;
    }

    public void isValid(final Person person) throws VerificationException {
        if (!emailVerifier.isEmailValid(person.getEmail())) {
            throw new VerificationException("Email is invalid");
        }

        if (!nameVerifier.isNameValid(person.getFullName())) {
            throw new VerificationException("Person name is invalid");
        }

        if (!surnameVerifier.isValid(person.getLastName())) {
            throw new VerificationException("Person last name is invalid");
        }
    }
}
