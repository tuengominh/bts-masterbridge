package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.util.DataSourceUtil;
import co.masterbridge.website.util.SqlBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CourseRepositoryJdbc implements CourseRepository {

    private JdbcTemplate jdbcTemplate;

    public CourseRepositoryJdbc() {
        this.jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSourceInPath());
    }

    @Override
    public void create(Course course) {

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public Course getById(long id) {
        return null;
    }

    @Override
    public Collection<Course> getAll() {
        return jdbcTemplate.query(
                "select * from courses",
                (rs1, rowNum) -> getCourse(rs1));
    }

    @Override
    public Collection<Course> find(CourseSearch courseSearch) {

        String sql = new SqlBuilder()
                .from("courses")
                .where("country","=", courseSearch.country)
                .where("field","like", "%" + courseSearch.fieldOfStudy + "%")
                .build();

        return jdbcTemplate.query(sql, (rs1, rowNum) -> getCourse(rs1));

    }

    @Override
    public void remove(Course course) {

    }

    public Course getCourse(ResultSet rs) throws SQLException {

        Course course = new Course();
        course.setCourseId(rs.getLong("course_id"));
        course.setCountry(rs.getString("country"));
        course.setFieldOfStudy(rs.getString("field"));

        return course;
    }
}
