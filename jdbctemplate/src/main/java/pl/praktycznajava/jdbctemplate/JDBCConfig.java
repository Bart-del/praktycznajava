package pl.praktycznajava.jdbctemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JDBCConfig {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://www.remotemysql.com:3306/KeLEWlhOPW");
        dataSource.setUsername("KeLEWlhOPW");
        dataSource.setPassword("6f6PswTwnh");

        return dataSource;
    }
}




