package co.masterbridge.website.controller;

import co.masterbridge.website.exception.NotFoundException;
import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseApiController {

    private CourseService courseService;

    @Autowired
    public CourseApiController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = GET)
    public Collection<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @RequestMapping(method = GET, path = "/{id}")
    public Course getCourseById(@PathVariable String id) throws NotFoundException {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return course;
        } else {
            throw new NotFoundException();
        }
    }

    @RequestMapping(method = POST)
    public String createCourse(@RequestBody Course course) {
        return courseService.createCourse(course).getCourseId();
    }

    @RequestMapping(method = POST, path = "/find")
    public Collection<Course> findCourses(@RequestBody CourseSearch courseSearch) {
        return courseService.findCourses(courseSearch);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public Course updateCourseById(@PathVariable String id, @RequestBody Course newCourse) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            courseService.updateCourse(id, newCourse);
        } else {
            createCourse(newCourse);
        }
        return course;
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public Collection<Course> removeCourseById(@PathVariable String id) {
        courseService.removeCourse(id);
        return getAllCourses();
    }
}
