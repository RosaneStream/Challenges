package rose.me.bank_operation_api.controller.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
      super(message);
  }
}