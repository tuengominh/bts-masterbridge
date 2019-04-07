package co.masterbridge.website;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.repository.CourseRepository;
import co.masterbridge.website.service.CourseService;
import co.masterbridge.website.util.DataSourceUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        //DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        //ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/university_schema.sql"));
    }

    @Bean
    public CommandLineRunner test(
            CourseService courseService,
            CourseRepository courseRepository) {

        return args -> {
        };
    }
}