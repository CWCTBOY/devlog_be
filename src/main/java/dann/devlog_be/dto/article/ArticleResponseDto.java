package dann.devlog_be.dto.article;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ArticleResponseDto {
  private final Long id;

  private final String title;

  private final String content;

  private final int likeCount;

  private final String thumbnailUrl;

  private final Date createdAt;

  private final Date updatedAt;

  private final int viewCount;

}
