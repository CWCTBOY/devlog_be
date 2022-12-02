package dann.devlog_be.repository.article;

import dann.devlog_be.entity.article.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewLogRepository extends JpaRepository<ViewLog, Long> {
}
