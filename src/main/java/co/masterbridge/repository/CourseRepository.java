package co.masterbridge.repository;

import co.masterbridge.model.Course;
import co.masterbridge.model.CourseSearch;
import co.masterbridge.util.DataSourceUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;

    public CourseRepository() {
        DataSource dataSource = DataSourceUtil.getDataSourceInPath();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Collection<Course> getAll() {
        return jdbcTemplate.query(
                "select * from courses",
                (rs1, rowNum) -> getCourse(rs1));
    }

    public Collection<Course> find(CourseSearch courseSearch) {

        String sql = "select * from courses";

        sql += " where country = '" + courseSearch.country + "'";
        sql += " , field = '" + courseSearch.fieldOfStudy + "'";

        //TODO: Create a list to store all conditions

        return jdbcTemplate.query(sql, (rs1, rowNum) -> getCourse(rs1));

    }

    public Course getCourse(ResultSet rs) throws SQLException {

        long id = rs.getLong("id");
        String country = rs.getString("country");
        String fieldOfStudy = rs.getString("field");

        Course course = new Course();
        course.setId(id);

        List<Course> courses = new ArrayList<>();

        if (country != null && fieldOfStudy != null) {
            courses.add(course);

        }
        return course;
    }
}
