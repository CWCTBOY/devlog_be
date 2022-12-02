package dann.devlog_be.entity.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "ARTICLE")
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ARTICLE_ID")
  private Long id;
  @NotNull
  @Column(length = 100)
  private String title;
  @NotNull
  @Column(length = 20000)
  private String content;

  @NotNull
  @Column(name = "LIKE_COUNT", columnDefinition = "INTEGER default '0'")
  private int likeCount;

  @NotNull
  @CreationTimestamp
  @Column(name = "CREATED_AT")
  private Timestamp createdAt;

  @JsonIgnore
  @OneToMany(mappedBy = "article")
  private List<ViewLog> viewCount;

  @Builder
  public Article(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
