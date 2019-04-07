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

@Repository
public class CourseRepositoryMongo implements CourseRepository {

    private MongoCollection<Document> courseCol;

    public CourseRepositoryMongo() {

        this.courseCol = MongoClients.create().getDatabase("masterbridge-website").getCollection("courses");
    }

    @Override
    public Collection<Course> getAll() {

        MongoCursor<Document> coursesCursor = courseCol.find().iterator();
        List<Course> courses = new ArrayList<>();
        while (coursesCursor.hasNext()) {
            courses.add(getCourseFromCursor(coursesCursor.next()));
        }
        coursesCursor.close();
        return courses;
    }

    @Override
    public Course getById(long id) {
        MongoCursor<Document> coursesCursor = courseCol.find(doc("_id", id)).iterator();
        Course course = getCourseFromCursor((Document) coursesCursor);
        coursesCursor.close();
        return course;
    }

    @Override
    public void create(Course course) {

        Document courseDoc = doc()
                .append("school_id", course.getSchoolId())
                .append("course_name", course.getCourseName())
                .append("country", course.getCountry())
                .append("city", course.getCity())
                .append("field", course.getFieldOfStudy())
                .append("tuition", course.getTuition())
                .append("attendance", course.getAttendance())
                .append("duration", course.getDuration());

        courseCol.insertOne(courseDoc);
    }

    @Override
    public Collection<Course> find(CourseSearch courseSearch) {
        Document query = doc()
                .append("country", courseSearch.country)
                .append("city", courseSearch.city)
                .append("field", courseSearch.fieldOfStudy)
                .append("tuition", courseSearch.tuition)
                .append("attendance", courseSearch.attendance)
                .append("duration", courseSearch.duration);

        MongoCursor<Document> coursesCursor = courseCol.find(query).iterator();
        List<Course> courses = new ArrayList<>();
        while (coursesCursor.hasNext()) {
            courses.add(getCourseFromCursor(coursesCursor.next()));
        }
        coursesCursor.close();
        return courses;
    }

    @Override
    public void update(long id, Course course) {
        Document query = doc("_id", id);
        Document update = doc()
                .append("$set", doc("school_id", course.getSchoolId()))
                .append("$set", doc("course_name", course.getCourseName()))
                .append("$set", doc("country", course.getCountry()))
                .append("$set", doc("city", course.getCity()))
                .append("$set", doc("field", course.getFieldOfStudy()))
                .append("$set", doc("tuition", course.getTuition()))
                .append("$set", doc("attendance", course.getAttendance()))
                .append("$set", doc("duration", course.getDuration()));

        courseCol.updateOne(query, update);
    }

    @Override
    public void remove(long id) {
        courseCol.deleteOne(doc("_id", id));
    }

    private Course getCourseFromCursor(Document doc) {

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
}
