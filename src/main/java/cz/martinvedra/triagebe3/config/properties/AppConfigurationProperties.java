package cz.martinvedra.triagebe3.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = AppConfigurationProperties.PREFIX_NAME)
public record AppConfigurationProperties(
        @DefaultValue("true") boolean enabled,
        CsasProperties csas
) {
    public static final String PREFIX_NAME = "app";

    public record CsasProperties(
            String baseUrl
    ) {}
}