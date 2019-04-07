package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static co.masterbridge.website.util.MongoUtil.doc;
import static com.mongodb.client.model.Filters.and;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class CourseRepositoryMongo implements CourseRepository {

    private MongoCollection<Document> courseCol;

    public CourseRepositoryMongo() {

        this.courseCol = MongoClients.create().getDatabase("masterbridge-website").getCollection("courses");
    }

    @Override
    public Collection<Course> getAll() {
        return getCoursesFromCursor(courseCol.find().iterator());
    }

    @Override
    public Course getById(long id) {
        return getCourseFromDoc(courseCol.find(eq("_id", id)).first());
    }

    @Override
    public void create(Course course) {
        courseCol.insertOne(getDocFromCourse(course));
    }

    @Override
    public Collection<Course> find(CourseSearch courseSearch) {
        Document query = (Document) and(
                eq("country", courseSearch.country),
                eq("city", courseSearch.city),
                eq("field", courseSearch.fieldOfStudy),
                eq("tuition", courseSearch.tuition),
                eq("attendance", courseSearch.attendance),
                eq("duration", courseSearch.duration));

        return getCoursesFromCursor(courseCol.find(query).iterator());
    }

    @Override
    public void update(long id, Course course) {
        courseCol.updateOne(eq("_id", id), doc().append("$set", getDocFromCourse(course)));
    }

    @Override
    public void remove(long id) {
        courseCol.deleteOne(eq("_id", id));
    }

    private Course getCourseFromDoc(Document doc) {
        Course course = new Course(
                doc.getInteger("_id"),
                doc.getInteger("school_id"),
                doc.getString("course_name"),
                doc.getString("country"),
                doc.getString( "city"),
                doc.getString("field"),
                doc.getInteger("tuition"),
                (Course.Attendance) doc.get("attendance"),
                (Course.Duration) doc.get("duration")
        );
        return course;
    }

    private Document getDocFromCourse(Course course) {
        return doc()
                .append("school_id", course.getSchoolId())
                .append("course_name", course.getCourseName())
                .append("country", course.getCountry())
                .append("city", course.getCity())
                .append("field", course.getFieldOfStudy())
                .append("tuition", course.getTuition())
                .append("attendance", course.getAttendance())
                .append("duration", course.getDuration());
    }

    private List<Course> getCoursesFromCursor(MongoCursor<Document> coursesCursor) {
        List<Course> courses = new ArrayList<>();
        while (coursesCursor.hasNext()) {
            courses.add(getCourseFromDoc(coursesCursor.next()));
        }
        coursesCursor.close();
        return courses;
    }
}
