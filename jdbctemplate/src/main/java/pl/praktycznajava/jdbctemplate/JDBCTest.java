package pl.praktycznajava.jdbctemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCTest {

    JDBCConfig jdbcConfig = new JDBCConfig();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(jdbcConfig.getDataSource());

    @Bean
    public void test(){
        createNewTable();
        addEmployee(1);
        addEmployee(2);
        addEmployee(3);

        int result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM EMPLOYEE", Integer.class);

        System.out.println(result);
    }


    public void createNewTable(){
        jdbcTemplate.execute("CREATE TABLE EMPLOYEE " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " country VARCHAR(255), " +
                " PRIMARY KEY ( id ))");
    }

    public void addEmployee(int id) {
        jdbcTemplate.update(
                "INSERT INTO EMPLOYEE VALUES (" + id + ", Anthony, Hopkins, USA");
    }


}
