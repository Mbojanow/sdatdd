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
  @ValueSource(strings = { "Bojanowski", "Nadratowska", "Bocianowski"})
  void shouldBeTypicalPolishSurname(final String surname) {
    final boolean actualValue = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(actualValue).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"-12", "ski", "wski", "Bojanowskaaa"})
  void shouldNotBeTypicalPolishSurname(final String surname) {
    final boolean actualValue = polishPersonUtil.isTypicalPolishSurname(surname);

    assertThat(actualValue).isFalse();
  }

  @ParameterizedTest
  @CsvSource({"Ala,Kwiatkowska,22",
              "Ula,Andrzejewska,18"})
  void shouldBeAdultWomanWithTypicalPolishSurname(final String name,
                                                  final String surname,
                                                  final int age) {
    final boolean result = polishPersonUtil.isAdultWomanWithTypicalPolishSurname(name, surname, age);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"Aa,Kwiatkowska,22",
              "Michal,Andrzejewska,18",
              "Ala,wska,19",
              "Ala,Bojanowski,33",
              "Ala,Kwiatkowska,17"})
  void shouldNotBeAdultWomanWithTypicalPolishSurname(final String name,
                                                  final String surname,
                                                  final int age) {
    final boolean result = polishPersonUtil.isAdultWomanWithTypicalPolishSurname(name, surname, age);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/test/name_data.csv")
  void shouldNotBeAdultWomanWithTypicalPolishSurname2(final String name,
                                                      final String surname,
                                                      final int age) {
    final boolean result = polishPersonUtil.isAdultWomanWithTypicalPolishSurname(name, surname, age);

    assertThat(result).isFalse();
  }












}