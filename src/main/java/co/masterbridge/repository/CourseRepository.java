package co.masterbridge.repository;

import co.masterbridge.model.Course;
import co.masterbridge.model.CourseSearch;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private JdbcTemplate jdbcTemplate;

    public List<Course> find(CourseSearch courseSearch) {

        String sql = "select * from courses";

        sql += " where country = '" + courseSearch.country + "'";
        sql += " where discipline = '" + courseSearch.discipline + "'";


        return jdbcTemplate.query(sql, (rs1, rowNum) -> getCourse(rs1));

    }

    public Course getCourse(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String country = rs.getString("country");
        String discipline = rs.getString("discipline");


        Course course = new Course();
        course.setId(id);

        List<Course> getCource = new ArrayList<>();

        if (country != null && discipline != null) {

            getCource.add(course);

        }
        return course;
    }
}
