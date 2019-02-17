package pl.sdacademy.mockitopractice;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DecoratedDependencyUsageTest {

  @Mock
  private DependencyA dependencyA;

  @Mock
  private DependencyB dependencyB;

  @InjectMocks
  private DecoratedDependencyUsage decoratedDependencyUsage;

  @Test
  void shouldThrowExceptionForDependencyA() {
    when(dependencyA.isValid(any())).thenReturn(false);

    assertThatThrownBy(() -> decoratedDependencyUsage.isInvalid(3))
        .hasMessage("DEPENDECY A FAILED");

    verify(dependencyA).isValid(3);
    verifyZeroInteractions(dependencyB);
  }

}