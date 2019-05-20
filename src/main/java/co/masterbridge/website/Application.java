package co.masterbridge.website;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    /**@Bean
    static CommandLineRunner test(
            CourseService courseService,
            CourseRepository courseRepository) {

        return args -> {
        };
    }*/

    @Bean
    public CommandLineRunner test() {

        return args -> {
            System.out.println("Loading Masterbridge.co");
        };
    }
}