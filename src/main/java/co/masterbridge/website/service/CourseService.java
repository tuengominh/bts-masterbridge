package co.masterbridge.website.service;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.repository.CourseRepository;
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

    public Course getCourseById(String id) { return courseRepository.getById(id); }

    public Course createCourse(Course course) {
        courseRepository.create(course);
        return course;
    }

    public Collection<Course> findCourses(CourseSearch courseSearch) {
        this.courseRepository.storeInput(courseSearch);
        return courseRepository.find(courseSearch);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.update(id, course); }

    public void removeCourse(String id) {
        courseRepository.remove(id);}
}
