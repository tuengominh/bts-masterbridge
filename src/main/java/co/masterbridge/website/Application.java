package co.masterbridge.website;

import co.masterbridge.website.util.DataSourceUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(Application.class, args);

        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/university_schema.sql"));
    }
}