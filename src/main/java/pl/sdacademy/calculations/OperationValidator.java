package pl.sdacademy.calculations;

public class OperationValidator {

  public boolean supports(final Operation operation) {
    return operation == Operation.ADD || operation == Operation.DIVIDE
        || operation == Operation.MULTIPLY || operation == Operation.SUBTRACT;
  }
}
