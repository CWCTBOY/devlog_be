package dann.devlog_be.service.article;

import dann.devlog_be.entity.article.Article;
import dann.devlog_be.entity.article.ViewLog;
import dann.devlog_be.repository.article.ArticleRepository;
import dann.devlog_be.repository.article.ViewLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Transactional
@Service
public class ViewLogServiceImpl implements ViewLogService {
  private final ArticleRepository articleRepository;
  private final ViewLogRepository viewLogRepository;

  @Autowired
  public ViewLogServiceImpl(ArticleRepository articleRepository, ViewLogRepository viewLogRepository) {
    this.articleRepository = articleRepository;
    this.viewLogRepository = viewLogRepository;
  }

  @Override
  public void addViewCount(Long articleId, HttpServletRequest request) {
    Article foundArticle = articleRepository.findById(articleId)
      .orElseThrow(() -> new NoSuchElementException("please check the id again."));
    ViewLog viewLog = ViewLog.builder()
      .article(foundArticle)
      .ip(ipParser(request))
      .build();
    viewLogRepository.save(viewLog);
  }

  private String ipParser(HttpServletRequest request) {
    String ip = request.getHeader("X-FORWARDED-FOR");
    if (ip == null) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

}
