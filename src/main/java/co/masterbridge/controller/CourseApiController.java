package co.masterbridge.controller;

import co.masterbridge.model.Course;
import co.masterbridge.model.CourseSearch;
import co.masterbridge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseApiController {

    private CourseService courseService;

    @Autowired
    public CourseApiController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Course> getCourseList(){
        return courseService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/find")
    public Collection<Course> findCourses(@RequestBody CourseSearch courseSearch) {
        return courseService.find(courseSearch);
    }
}
