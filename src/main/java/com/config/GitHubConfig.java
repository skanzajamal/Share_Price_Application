package com.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.github")
@Data
public class GitHubConfig {

    private String clientId;  // value store in environment variable due to confidentiality
    private String clientSecret;   // value store in environment variable due to confidentiality

} //ENDCLASS
