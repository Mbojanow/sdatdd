package pl.sdacademy.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import pl.sdacademy.exceptions.PersonUpdateFailedException;

class PersonTest {

    private static final String FIRST_NAME = "Michal";
    private static final String LAST_NAME = "Kowalski";

    @Test
    void shouldCreatePersonCorrectly() {
        final Person person = Person.create(FIRST_NAME, LAST_NAME);

        assertAll(
                () -> assertEquals(FIRST_NAME, person.getFirstName()),
                () -> assertEquals(LAST_NAME, person.getLastName())
        );
    }

    @Test
    void shouldGetFullName() {
        final Person person = Person.create(FIRST_NAME, LAST_NAME);

        assertThat(person.getFullName())
                .startsWith(FIRST_NAME)
                .endsWith(LAST_NAME)
                .contains(" ");
    }

    @Test
    void shouldThrowExceptionWhenAgeIsNegative() {
        final Person person = new Person();

        final PersonUpdateFailedException throwable =
            assertThrows(PersonUpdateFailedException.class,
            () -> person.setPersonDetails("test@gmail.com", -1));
        assertThat(throwable.getMessage()).isEqualTo("Age has to be positive");
    }
}