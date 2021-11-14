package pl.praktycznajava.springboottips;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass(CustomSecurity.class)
public class MyWebAutoConfiguration {
    //..

    @Bean
    @ConditionalOnBean(name = "dataSource")
    EntityManagerFactoryBean entityManagerFactoryBean(){
        return new EntityManagerFactoryBean();
    }

    @Bean
    @ConditionalOnProperty(
            name = "database",
            havingValue = "test"
    )
    TestDataSource setTestDataSource(){
       return new TestDataSource();
    }
}


