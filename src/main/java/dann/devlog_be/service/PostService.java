package dann.devlog_be.service;

import dann.devlog_be.entity.Post;
import lombok.RequiredArgsConstructor;
import dann.devlog_be.dto.WritePostReq;
import org.springframework.stereotype.Service;
import dann.devlog_be.repository.PostRepository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {
  private final String NO_SUCH_ELEMENT = "Please check the id.";
  private final PostRepository postRepository;

  @Transactional
  public Post save(WritePostReq writePostReq) {
    Post post = Post.builder()
      .title(writePostReq.getTitle())
      .content(writePostReq.getContent())
      .build();
    return postRepository.save(post);
  }

  @Transactional
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Transactional
  public Post findById(Long id) {
    return postRepository.findById(id)
      .orElseThrow(() -> new NoSuchElementException(NO_SUCH_ELEMENT));
  }

  @Transactional
  public Post updateById(Long id, WritePostReq writePostReq) {
    Post postEntity = postRepository.findById(id)
      .orElseThrow(() -> new NoSuchElementException(NO_SUCH_ELEMENT));
    postEntity.setTitle(writePostReq.getTitle());
    postEntity.setContent(writePostReq.getContent());
    return postEntity;
  }

  public String deleteById(Long id) {
    try {
      postRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT);
    }
    return "ok";
  }
}
