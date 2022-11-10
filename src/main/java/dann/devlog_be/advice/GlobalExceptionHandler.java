package dann.devlog_be.advice;

import dann.devlog_be.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({NoSuchElementException.class})
  protected ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementException e) {
    final ErrorResponse errorResponse = ErrorResponse.builder()
      .code("Item Not Found")
      .message(e.getMessage())
      .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
}
