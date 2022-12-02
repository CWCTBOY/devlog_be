package dann.devlog_be.content.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
class JpaContentRepositoryTest {
  static EntityManager entityManager;
  static JpaContentRepository repository = new JpaContentRepository(entityManager);

  @Test
  void save() {
  }

  @Test
  void findById() {
  }

  @Test
  void findAll() {
  }
}