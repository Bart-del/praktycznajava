package pl.praktycznajava.springboottips.propierties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
public class Database {
    String url;
    String username;
    String password;
}


