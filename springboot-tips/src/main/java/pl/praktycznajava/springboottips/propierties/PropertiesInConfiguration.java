package pl.praktycznajava.springboottips.propierties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


public class PropertiesInConfiguration {

    //....

    @Value("${website.url}")
    private String websiteURL; //https://praktycznajava.pl
}

