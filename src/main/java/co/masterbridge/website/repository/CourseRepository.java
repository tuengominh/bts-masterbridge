package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;

import java.util.Collection;

public interface CourseRepository {

        Collection<Course> getAll();

        Course getById(String id);

        void create(Course course);

        Collection<Course> find(CourseSearch courseSearch);

        void update(String id, Course course);

        void remove(String id);

        void storeInput(CourseSearch courseSearch);
}
