package dann.devlog_be.entity.article;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "VIEW_LOG")
public class ViewLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @NotNull
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ARTICLE_ID")
  private Article article;

  @NotNull
  @Column(name = "IP")
  private String ip;

  @NotNull
  @CreationTimestamp
  @Column(name = "LOGGED_AT")
  private Timestamp loggedAt;


  @Builder
  public ViewLog(Article article, String ip) {
    this.article = article;
    this.ip = ip;
  }
}
