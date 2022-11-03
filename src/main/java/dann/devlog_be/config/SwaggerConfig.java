package dann.devlog_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
  @Bean
  public Docket api(){
    return new Docket(DocumentationType.OAS_30)
      .useDefaultResponseMessages(false)
      .select()
      .apis(RequestHandlerSelectors.basePackage("dann.devlog_be.controller")) // 각자 패키지에 알맞게
      .paths(PathSelectors.any())
      .build()
      .apiInfo(apiInfo());

  }

  private ApiInfo apiInfo(){
    return new ApiInfoBuilder()
      .title("GDSC API DOCS")
      .description("API Document for GDSC Web Blog")
      .version("1.0")
      .build();
  }
}
