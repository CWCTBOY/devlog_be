package dann.devlog_be.dto.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleRequestDto {

  @ApiModelProperty(value = "id of the article. this is optional")
  private final Long id;

  @ApiModelProperty(value = "title of the article.")
  private final String title;

  @ApiModelProperty(value = "content of the article.")
  private final String content;

  @ApiModelProperty(value = "tag of the article.")
  private final List<String> selectedTags;
}
