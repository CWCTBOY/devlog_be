package dann.devlog_be.controller.article;

import dann.devlog_be.dto.article.ArticleRequestDto;
import dann.devlog_be.dto.article.ArticleResponseDto;
import dann.devlog_be.entity.article.Article;
import dann.devlog_be.service.article.ArticleService;
import dann.devlog_be.service.article.ViewLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/article")
@RestController
public class ArticleController {

  private final ViewLogService viewLogService;
  private final ArticleService articleService;

  @Autowired
  public ArticleController(ViewLogService viewLogService, ArticleService articleService) {
    this.viewLogService = viewLogService;
    this.articleService = articleService;
  }

  @ApiOperation(value = "create a new article")
  @PostMapping("/new")
  public ResponseEntity<Long> create(@RequestBody ArticleRequestDto articleDto) {
    return new ResponseEntity<>(articleService.save(articleDto), HttpStatus.CREATED);
  }

  @ApiOperation(value = "search an article by article id.")
  @GetMapping("/{articleId}")
  public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    Article article = articleService.findById(articleId);
    viewLogService.addViewCount(articleId, request);
    return new ResponseEntity<>(articleService.findById(articleId), HttpStatus.OK);
  }

  @ApiOperation(value = "search all the articles.")
  @GetMapping("/all")
  public ResponseEntity<List<ArticleResponseDto>> getAllArticles() {
    return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
  }

  //  public void create(@RequestBody ArticleDto articleDto) {
//    List<String> tags = articleDto.getSelectedTags();
//    for (String tag : tags) {
//      System.out.println(tag);
//    }
//  }
//  @ApiOperation(value = "update an article by id.")
//  @PutMapping("/{id}")
//  public ResponseEntity<Long> updateById(@PathVariable Long articleId, @RequestBody ArticleDto articleDto) {
//    return new ResponseEntity<>(articleService.updateById(articleId, articleDto), HttpStatus.OK);
//  }
//
//  @ApiOperation(value = "delete a specific article by article id.")
//  @DeleteMapping("/{id}")
//  public ResponseEntity<Long> deleteArticleById(@PathVariable Long articleId) {
//    System.out.println(articleId);
//    return new ResponseEntity<>(articleService.deleteById(articleId), HttpStatus.OK);
//  }
}
