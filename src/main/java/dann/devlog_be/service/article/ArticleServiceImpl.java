package dann.devlog_be.service.article;

import dann.devlog_be.dto.article.ArticleRequestDto;
import dann.devlog_be.dto.article.ArticleResponseDto;
import dann.devlog_be.entity.article.Article;
import dann.devlog_be.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;

  @Autowired
  public ArticleServiceImpl(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  @Override
  public Long save(ArticleRequestDto articleDto) {
    Article article = Article.builder()
      .title(articleDto.getTitle())
      .content(articleDto.getContent())
      .build();
    return articleRepository.save(article).getId();
  }

  @Override
  public Long updateById(Long articleId, ArticleRequestDto articleDto) {
    Article foundArticle = articleRepository.findById(articleId)
      .orElseThrow(() -> new NoSuchElementException("please check the id again."));
    foundArticle.setTitle(articleDto.getTitle());
    foundArticle.setContent(articleDto.getContent());
    return foundArticle.getId();
  }

  @Override
  public Article findById(Long articleId) {
    return articleRepository.findById(articleId)
      .orElseThrow(() -> new NoSuchElementException("please check the id again."));
  }

  @Override
  public List<ArticleResponseDto> findAll() {
    return toResponse(articleRepository.findAll());
  }

  @Override
  public Long deleteById(Long articleId) {
    try {
      articleRepository.deleteById(articleId);
    } catch (EmptyResultDataAccessException e) {
      throw new NoSuchElementException("please check the id again.");
    }
    return articleId;
  }

  public List<ArticleResponseDto> toResponse(List<Article> list) {
    return list.stream().map((Article item) -> {
      return ArticleResponseDto.builder()
        .id(item.getId())
        .title(item.getTitle())
        .content(item.getContent())
        .createdAt(item.getCreatedAt())
        .likeCount(item.getLikeCount())
        .viewCount(item.getViewCount().size())
        .build();
    }).collect(Collectors.toList());
  }
}
