package dann.devlog_be.service.article;

import dann.devlog_be.dto.article.ArticleRequestDto;
import dann.devlog_be.dto.article.ArticleResponseDto;
import dann.devlog_be.entity.article.Article;

import java.util.List;

public interface ArticleService {
  public Long save(ArticleRequestDto articleDto);

  public Long updateById(Long articleId, ArticleRequestDto articleDto);

  public Article findById(Long articleId);

  public List<ArticleResponseDto> findAll();

  public Long deleteById(Long articleId);
}
