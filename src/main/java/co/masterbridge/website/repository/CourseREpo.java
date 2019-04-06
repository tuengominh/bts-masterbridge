package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;

import java.util.Collection;

public interface CourseREpo {


        void create(Course course);

        void update(Course course);

        Course getById(long id);

        Collection<Course> getAll();

        Collection<Course> find(CourseSearch courseSearch);

}
