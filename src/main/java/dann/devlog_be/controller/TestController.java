package dann.devlog_be.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
  @ResponseBody
  @GetMapping("/")
  public String home() {
    return "Home page!";
  }

  @ResponseBody
  @GetMapping("/hello")
  public String hello() {
    return "Hello World!";
  }
}
