package co.masterbridge.website.repository;

import co.masterbridge.website.model.Course;
import co.masterbridge.website.model.CourseSearch;
import co.masterbridge.website.util.MongoUtil;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static co.masterbridge.website.util.MongoUtil.doc;
import static com.mongodb.client.model.Filters.*;

@Repository
public class CourseRepositoryMongo implements CourseRepository {

    private MongoCollection<Document> courseCol;
    private MongoCollection<Document> courseSearchCol;

    public CourseRepositoryMongo(@Value("${mongoUri}") String mongoUri) {
        this.courseCol = MongoClients.create(mongoUri).getDatabase("masterbridge").getCollection("courses");
        this.courseSearchCol = MongoClients.create(mongoUri).getDatabase("masterbridge").getCollection("courseSearches");
    }

    @Override
    public Collection<Course> getAll() {
        return getCoursesFromCursor(courseCol.find().iterator());
    }

    @Override
    public Course getById(String id) {
        return getCourseFromDoc(courseCol.find(eq("_id", id)).first());
    }

    @Override
    public void create(Course course) {
        courseCol.insertOne(getDocFromCourse(course));
    }

    @Override
    public Collection<Course> find(CourseSearch courseSearch) {
        Document query = new Document();

        MongoUtil.appendIfNotNull(query, "country", courseSearch.country);
        MongoUtil.appendIfNotNull(query,"city", courseSearch.city);
        MongoUtil.appendIfNotNull(query,"field", courseSearch.fieldOfStudy);
        //TODO: MongoUtil.appendIfNotNull(query,"tuition", courseSearch.tuition);
        MongoUtil.appendIfNotNull(query,"attendance", courseSearch.attendance);
        MongoUtil.appendIfNotNull(query,"duration", courseSearch.duration);

        return getCoursesFromCursor(courseCol.find(query).iterator());
    }

    @Override
    public void storeInput(CourseSearch courseSearch) {
        courseSearchCol.insertOne(doc()
                .append("field", courseSearch.getFieldOfStudy())
                .append("country", courseSearch.getCountry())
                .append("city", courseSearch.getCity())
                .append("tuition", courseSearch.getTuition())
                .append("attendance", courseSearch.getAttendance())
                .append("duration", courseSearch.getDuration()));
    }

    @Override
    public void update(String id, Course course) {
        courseCol.updateOne(eq("_id", id), getDocFromCourse(course));
    }

    @Override
    public void remove(String id) {
        courseCol.deleteOne(eq("_id", id));
    }

    private Course getCourseFromDoc(Document doc) {
        return new Course(
                doc.getObjectId("_id").toString(),
                null, // TODO doc.getObjectId("school_id").toString()
                doc.getString("course_name"),
                doc.getString("country"),
                doc.getString("city"),
                doc.getList("field", String.class),
                doc.getInteger("tuition"),
                (Course.Attendance) doc.get("attendance"),
                (Course.Duration) doc.get("duration")
        );
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
