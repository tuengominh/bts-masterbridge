package co.masterbridge.controller;

import co.masterbridge.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseApiController {

    private CourseService courseService;

    @Autowired
    public CourseApiController(CourseService courseService) {
        this.courseService = courseService;
    }


}
