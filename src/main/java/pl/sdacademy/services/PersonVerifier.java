package pl.sdacademy.services;

import pl.sdacademy.exceptions.VerificationException;
import pl.sdacademy.user.Person;

public class PersonVerifier {

    private final AgeVerifier ageVerifier;
    private final EmailVerifier emailVerifier;
    private final NameVerifier nameVerifier;
    private final SurnameVerifier surnameVerifier;
    private final PersonSender personSender;

    public PersonVerifier(final AgeVerifier ageVerifier, final EmailVerifier emailVerifier, final NameVerifier nameVerifier,
                          final SurnameVerifier surnameVerifier, final PersonSender personSender) {
        this.ageVerifier = ageVerifier;
        this.emailVerifier = emailVerifier;
        this.nameVerifier = nameVerifier;
        this.surnameVerifier = surnameVerifier;
        this.personSender = personSender;
    }

    public void isValidAndSend(final Person person) throws VerificationException {
        if (!ageVerifier.isAgeValid(person.getAge())) {
            throw new VerificationException("Age is invalid");
        }

        if (!emailVerifier.isEmailValid(person.getEmail())) {
            throw new VerificationException("Email is invalid");
        }

        if (!nameVerifier.isNameValid(person.getFullName())) {
            throw new VerificationException("Person name is invalid");
        }

        if (!surnameVerifier.isValid(person.getLastName())) {
            throw new VerificationException("Person last name is invalid");
        }
        personSender.send(person);
    }
}
