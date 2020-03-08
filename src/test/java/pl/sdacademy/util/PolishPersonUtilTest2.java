package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PolishPersonUtilTest2 {

  private PolishPersonUtil polishPersonUtil;

  @BeforeEach
  void setUp() {
    polishPersonUtil = new PolishPersonUtil();
  }

  @ParameterizedTest
  @ValueSource(strings = { "Adamski", "Adamska" })
  void shouldBeTypicalPolishSurname(final String surname) {
    final boolean isTPS = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(isTPS).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"ski", "Adamskix", "ska"})
  void shouldNotBeTypicalPolishSurname(final String surname) {
    final boolean isTPS = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(isTPS).isFalse();
  }

  @ParameterizedTest
  // value - klucz w adnotacji - możemy pominąć!
  @CsvSource({
      "Andrzej, Kowalska",
      "Matylda, Kowalski",
      "A, Kowalska",
      "Matylda, ska"
  })
  void shouldNotBeTypicalPolishWomanWithTypicalPolishSurname(final String name, final String surname) {
    final boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/polishnames.txt")
  void shouldNotBeTypicalPolishWomanWithTypicalPolishSurname2(final String name, final String surname) {
    final boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(result).isFalse();
  }

}