package dann.devlog_be.service.article;

import javax.servlet.http.HttpServletRequest;

public interface ViewLogService {
  void addViewCount(Long articleId, HttpServletRequest request);
}
