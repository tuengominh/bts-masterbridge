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

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("masterbridge-website");
        this.courseCol = database.getCollection("courses");
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
    public void update(Course course, String property, Object value) {
        Document query = doc("_id", course.getCourseId());
        Document update = doc("$set", doc(property, value));
        courseCol.updateOne(query, update);
    }

    @Override
    public Collection<Course> getAll() {

        MongoCursor<Document> coursesCursor = courseCol.find().iterator();
        List<Course> courses = new ArrayList<>();
        try {
            while (coursesCursor.hasNext()) {
                courses.add(getCourseFromCursor(coursesCursor.next()));
            }
        } finally {
            coursesCursor.close();
        }
        return courses;
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

    @Override
    public Course getById(long id) {
        return null;
    }

    @Override
    public Collection<Course> find(CourseSearch courseSearch) {
        return null;
    }

    @Override
    public void remove(Course course) {

    }
}
