package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.util.DataSourceUtil;
import co.masterbridge.website.util.SqlBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CourseRepositoryJdbc implements CourseRepository {

    private JdbcTemplate jdbcTemplate;

    final String INSERT_STATEMENT = "insert into courses (school_id, course_name, country, field) values (?, ?, ?, ?)";
    final String UPDATE_STATEMENT = "update courses set country = ?, field = ? where id = ?";

    public CourseRepositoryJdbc() {
        this.jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSourceInPath());
    }

    @Override
    public Collection<Course> getAll() {
        return jdbcTemplate.query(
                "select * from courses",
                (rs1, rowNum) -> getCourse(rs1));
    }

    @Override
    public Course getById(long id) {
        String sql = new SqlBuilder()
                .from("courses")
                .where("course_id","=", id)
                .build();

        return jdbcTemplate.queryForObject(sql, (rs1, rowNum) -> getCourse(rs1));
    }

    @Override
    public void create(Course course) {
        jdbcTemplate.update(INSERT_STATEMENT, course.getSchoolId(), course.getCourseName(), course.getCountry(), course.getFieldOfStudy());
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
    public void update(long id, Course course) {
        jdbcTemplate.update(UPDATE_STATEMENT, course.getCountry(), course.getFieldOfStudy(), id);
    }

    @Override
    public void remove(long id) {
        jdbcTemplate.update("delete from courses where id = " + id);
    }

    @Override
    public void storeInput(CourseSearch courseSearch) {
        /* using Mongo */
    }

    private Course getCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getLong("course_id"));
        course.setCountry(rs.getString("country"));
        course.setFieldOfStudy(rs.getString("field"));

        return course;
    }
}
