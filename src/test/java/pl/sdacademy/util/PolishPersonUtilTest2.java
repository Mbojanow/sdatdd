package pl.sdacademy.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Polka o polskim nazwisku -> imie kończy się na a, długość minimum 3, nazwisko długość 7, "ska"


class PolishPersonUtilTest2 {

  private PolishPersonUtil polishPersonUtil = new PolishPersonUtil();

  @Test
  void shouldBePolishWomanWithTypicalSurname() {
    String firstName = "Ala";
    String lastName = "Andrzejewska";

    boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(firstName, lastName);

    assertThat(result).isTrue();
  }

  @Test
  void shouldNotBePolishWomanWithTypicalSurnameWhenNameTooShort() {
    String firstName = "Li";
    String lastName = "Andrzejewska";

    boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(firstName, lastName);

    assertThat(result).isFalse();
  }

  @Test
  void shouldNotBePolishWomanWithTypicalSurnameWhenNameDoesNotEndWithA() {
    String firstName = "Lili";
    String lastName = "Andrzejewska";

    boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(firstName, lastName);

    assertThat(result).isFalse();
  }

  @Test
  void shouldNotBePolishWomanWithTypicalSurnameWhenLastnameTooShort() {
    String firstName = "Ala";
    String lastName = "Aska";

    boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(firstName, lastName);

    assertThat(result).isFalse();
  }

  @Test
  void shouldNotBePolishWomanWithTypicalSurnameWhenLastDoesNotEndWithSka() {
    String firstName = "Ala";
    String lastName = "Andrzejewski";

    boolean result = polishPersonUtil.isWomanWithTypicalPolishSurname(firstName, lastName);

    assertThat(result).isFalse();
  }

}