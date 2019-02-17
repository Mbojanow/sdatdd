package pl.sdacademy.mockitopractice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.sdacademy.exceptions.DatabaseConnectionException;

@ExtendWith(MockitoExtension.class)
class DependencyUsageTest {

  @Mock
  private DependencyA dependencyA;

  @Mock
  private DependencyB dependencyB;

  @InjectMocks
  private DependencyUsage dependencyUsage;

  @Test
  void shouldThrowExceptionForDependencyA() {
    final int testedValue = 3;
    when(dependencyA.isValid(testedValue)).thenReturn(false);

    assertThrows(DatabaseConnectionException.class, () -> dependencyUsage.isInvalid(testedValue));

    verify(dependencyA).isValid(testedValue);
    verifyZeroInteractions(dependencyB);
  }

  @Test
  void shouldThrowExceptionForDependencyB() {
    final int testedValue = 3;
    when(dependencyA.isValid(testedValue)).thenReturn(true);
    when(dependencyB.isValid(testedValue)).thenReturn(false);

    assertThrows(DatabaseConnectionException.class, () -> dependencyUsage.isInvalid(testedValue));

    verify(dependencyA).isValid(testedValue);
    verify(dependencyB).isValid(testedValue);
  }
}