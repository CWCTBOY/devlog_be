package dann.devlog_be.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class WritePostReq {
  @ApiModelProperty(example = "Title of the Article")
  private String title;
  @ApiModelProperty(example = "Content of the Article")
  private String content;

  public WritePostReq(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
