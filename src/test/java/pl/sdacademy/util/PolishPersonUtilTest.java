package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PolishPersonUtilTest {

  private PolishPersonUtil polishPersonUtil;

  @BeforeEach
  void setUp() {
    polishPersonUtil = new PolishPersonUtil();
  }

  @ValueSource(strings = { "Kowalski", "Kowalska" })
  @ParameterizedTest
  void shouldBeTypicalPolishSurname(final String surname) {
    final boolean typicalPolishSurname = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(typicalPolishSurname).isTrue();
  }

  @ValueSource(strings = { "ski", "ska", "blablabla" })
  @ParameterizedTest
  void shouldNotBeTypicalPolishSurname(final String surname) {
    final boolean typicalPolishSurname = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(typicalPolishSurname).isFalse();
  }

  @CsvSource({"Ala, Kowalska", "Ula, Andrzejewska"})
  @ParameterizedTest
  void shouldBePolishWomanWithTypicalSurname(final String name, final String surname) {
    final boolean womanWithTypicalPolishSurname = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(womanWithTypicalPolishSurname).isTrue();
  }

  @CsvFileSource(resources = "/test.csv")
  @ParameterizedTest
  void shouldNotBePolishWomanWithTypicalSurname(final String name, final String surname) {
    final boolean womanWithTypicalPolishSurname = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(womanWithTypicalPolishSurname).isFalse();
  }
}