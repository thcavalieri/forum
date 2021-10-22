package br.com.thiagocavalieri.forum.swagger;

import br.com.thiagocavalieri.forum.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket forumApiDocumentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.thiagocavalieri.forum"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(User.class)
                .globalRequestParameters(
                Collections.singletonList(
                        new RequestParameterBuilder()
                                .name("Authorization")
                                .description("JWT Token Authorization")
                                .in(ParameterType.HEADER)
                                .required(false)
                                .build()));
    }

}
