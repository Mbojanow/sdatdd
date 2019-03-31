package pl.sdacademy.calculations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class OperationValidatorTest {

  private OperationValidator operationValidator;

  @BeforeEach
  void setUp() {
    operationValidator = new OperationValidator();
  }

  @Test
  void shouldSupportAddOperation() {
    final boolean isSupported = operationValidator.supports(Operation.ADD);

    assertThat(isSupported).isTrue();
  }

  @ParameterizedTest
  @EnumSource(Operation.class)
  void shouldSupportOperation(final Operation operation) {
    final boolean isSupported = operationValidator.supports(operation);

    assertThat(isSupported).isTrue();
  }
}