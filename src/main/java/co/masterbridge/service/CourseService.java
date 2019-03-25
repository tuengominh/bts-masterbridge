package co.masterbridge.service;

import co.masterbridge.model.Course;
import co.masterbridge.model.CourseSearch;
import co.masterbridge.repository.CourseRepository;
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

    public Collection<Course> getAll() {
        return courseRepository.getAll();
    }

    public Collection<Course> find(CourseSearch courseSearch) {
        return courseRepository.find(courseSearch);
    }
    //TODO: store CourseSearch => MongoDB (?)
}
