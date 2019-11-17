package pl.sdacademy.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("getAge")
    void shouldThrowWhenSettingDetailsWithInvalidAge(final Integer age) {
        final String email = "random@test.com";
        final Person person = Person.create("Andrzej", "Andrzejewski");

        assertThatExceptionOfType(PersonUpdateFailedException.class)
            .isThrownBy(() -> person.setPersonDetails(email, age))
        .withMessageContaining("be positive")
        .withNoCause();
    }

    static Stream<Arguments> getAge() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of((Integer)null)
        );
    }

}