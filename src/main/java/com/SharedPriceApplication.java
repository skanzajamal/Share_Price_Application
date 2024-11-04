package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class SharedPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedPriceApplication.class, args);
    }

    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/stockPrices/*"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Shared Price API",
                "Application in JAVA",
                "1.0",
                 "Free to use",
                new springfox.documentation.service.Contact("Kanza Jamal", "https://github.com/skanzajamal", "k122060@nu.ed.pk"),
                "API License",
                "https://github.com/skanzajamal",
                Collections.emptyList());
    }

} //ENDCLASS
