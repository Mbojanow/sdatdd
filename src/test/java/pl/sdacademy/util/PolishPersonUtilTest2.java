package pl.sdacademy.util;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class PolishPersonUtilTest2 {

  private PolishPersonUtil polishPersonUtil;

  @BeforeEach
  void setUp() {
    polishPersonUtil = new PolishPersonUtil();
  }

  @ParameterizedTest
  @CsvSource({
      "Ula, Andrzejewska",
      "Ola, Wolska",
      "Kasia, Wiśniewska"
  })
  void shouldBeTypicalPolishWomanName(final String name, final String surname) {
    final boolean actualValue = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(actualValue).isTrue();
  }

  @ParameterizedTest
//  @CsvSource({
//      "Ca, Andrzejewska",
//      "Michal, Wolska",
//      "Kasia, Wiśniewski",
//      "Ula, ska"
//  })
  @CsvFileSource(resources = "/javagda25/data.csv")
  void shouldNotBeTypicalPolishWomanName(final String name, final String surname) {
    final boolean actualValue = polishPersonUtil.isWomanWithTypicalPolishSurname(name, surname);

    assertThat(actualValue).isFalse();
  }

}