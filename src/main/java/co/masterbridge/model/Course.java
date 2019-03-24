package co.masterbridge.model;

public class Course {


   private long id;
   private String country;
   private String courseName;
   private String city;
   private String fieldOfStudy;
   private long tuition;
   private Attendance attendance = Attendance.FULLTIME;
   private Duration duration = Duration.ONE;

    public Course() {

    }

    public Course(long id, String country, String courseName, String city, String fieldOfStudy, long tuition, Attendance attendance, Duration duration) {
        this.id = id;
        this.country = country;
        this.courseName = courseName;
        this.city = city;
        this.fieldOfStudy = fieldOfStudy;
        this.tuition = tuition;
        this.attendance = attendance;
        this.duration = duration;
    }

    public enum Duration {
        ONE ("One"), TWO ("Two");

        private String initialString;

        Duration(String initialString) {
            this.initialString = initialString;
        }
    }

    public enum Attendance {
        FULLTIME ("Full-time"), PARTTIME("Part-time");

        private String initialString;

        Attendance(String initialString) {
            this.initialString = initialString;
        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public void setTuition(long tuition) {
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
