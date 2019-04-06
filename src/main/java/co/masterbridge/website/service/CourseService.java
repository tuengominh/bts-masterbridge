package co.masterbridge.website.service;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.repository.CourseRepository;
import co.masterbridge.website.repository.CourseRepositoryJdbc;
import co.masterbridge.website.repository.CourseRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService (CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Collection<Course> getAllCourses() {
        return courseRepository.getAll();
    }

    public Course createCourse() {
        Course course = new Course();
        courseRepository.create(course);
        return course;
    }

    public void updateCourse(Course course) {
        courseRepository.update(course); }

    public void removeCourse(Course course) {
        courseRepository.remove(course);}

    public Collection<Course> findCourses(CourseSearch courseSearch) {
        return courseRepository.find(courseSearch);
    }

    public Course getCourseById(long id) { return courseRepository.getById(id); }

}
