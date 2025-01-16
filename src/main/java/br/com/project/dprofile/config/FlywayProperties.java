package br.com.project.dprofile.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.flyway")
public class FlywayProperties {

    private String locations;

    private String schemas;

    private String baselineDescription;

    private boolean continueOnFail;
}
