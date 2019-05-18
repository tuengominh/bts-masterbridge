package co.masterbridge.website.model;

import java.util.List;

public class Course {

    private String courseId;
    private String schoolId;
    private String courseName;
    private String country; //TODO: dropdown list
    private String city; //TODO: dropdown list
    private List<String> fieldOfStudy; //TODO: case sensitive
    private int tuition;
    private Attendance attendance;
    private Duration duration;
    //TODO: Curriculum (binary file), Images (binary file), Teacher's profiles (?) & Employers (?) => S3 storage
    //TODO: List of Alumnus (Users studying at that school)

    public enum Duration {SIX_MONTHS(6), NINE_MONTHS(9), ONE_YEAR(12), TWO_YEAR(24);
        public int month;
        Duration(int month) {
            this.month = month;
        }

    }

    public enum Attendance {FULL_TIME, PART_TIME, ONLINE}

    public Course() {}

    public Course(String courseId, String schoolId, String courseName, String country, String city, List<String> fieldOfStudy, int tuition, Attendance attendance, Duration duration) {
        this.courseId = courseId;
        this.schoolId = schoolId;
        this.courseName = courseName;
        this.country = country;
        this.city = city;
        this.fieldOfStudy = fieldOfStudy;
        this.tuition = tuition;
        this.attendance = attendance;
        this.duration = duration;
    }

    public Course(String schoolId, String courseName, String country, String city, List<String> fieldOfStudy, int tuition, Attendance attendance, Duration duration) {
        this.schoolId = schoolId;
        this.courseName = courseName;
        this.country = country;
        this.city = city;
        this.fieldOfStudy = fieldOfStudy;
        this.tuition = tuition;
        this.attendance = attendance;
        this.duration = duration;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(List<String> fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public long getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

}
