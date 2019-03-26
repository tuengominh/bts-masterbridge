package co.masterbridge.website.model;

public class Course {

    private long courseId;
    private long schoolId;
    private String courseName;
    private String country; //TODO: dropdown list
    private String city; //TODO: dropdown list
    private String fieldOfStudy; //TODO: case sensitive
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

    public Course(long courseId, long schoolId, String courseName, String country, String city, String fieldOfStudy, int tuition, Attendance attendance, Duration duration) {
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

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
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

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
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
