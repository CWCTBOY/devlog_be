package dann.devlog_be.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
  private String code;
  private String message;

  @Builder
  public ErrorResponse(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
