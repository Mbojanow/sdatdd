package pl.sdacademy.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.sdacademy.exceptions.PersonUpdateFailedException;

import java.util.Optional;

import static java.util.Objects.isNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of={"firstName"})
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
}
