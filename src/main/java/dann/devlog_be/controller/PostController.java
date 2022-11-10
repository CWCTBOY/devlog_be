package dann.devlog_be.controller;

import dann.devlog_be.entity.Post;
import lombok.RequiredArgsConstructor;
import dann.devlog_be.dto.WritePostReq;
import dann.devlog_be.service.PostService;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/post")
@RestController
public class PostController {
  private final PostService postService;

  @ApiOperation(value = "Post a Article.", notes = "Post a Article.")
  @PostMapping("")
  public ResponseEntity<Post> save(@RequestBody WritePostReq writePostReq) {
    return new ResponseEntity<>(postService.save(writePostReq), HttpStatus.CREATED);
  }

  @ApiOperation(value = "Search all the Articles.", notes = "Search all the Articles.")
  @GetMapping("")
  public ResponseEntity<List<Post>> findAll() {
    return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
  }

  @ApiImplicitParam(name = "id", value = "Id of the article.")
  @ApiOperation(value = "Search a specific Articles.", notes = "Search a specific Articles.")
  @GetMapping("/{id}")
  public ResponseEntity<Post> findById(@PathVariable Long id) {
    return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
  }

  @ApiImplicitParam(name = "id", value = "Id of the article.")
  @ApiOperation(value = "Update the Article.", notes = "Update the Article.")
  @PutMapping("/{id}")
  public ResponseEntity<Post> updateById(@PathVariable Long id, @RequestBody WritePostReq writePostReq) {
    return new ResponseEntity<>(postService.updateById(id, writePostReq), HttpStatus.OK);
  }

  @ApiImplicitParam(name = "id", value = "Id of the article.")
  @ApiOperation(value = "Delete the Article.", notes = "Delete the Article.")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return new ResponseEntity<>(postService.deleteById(id), HttpStatus.OK);
  }
}
