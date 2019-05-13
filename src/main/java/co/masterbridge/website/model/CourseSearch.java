package co.masterbridge.website.model;

public class CourseSearch {

    public String country;
    public String fieldOfStudy;
    public String city;
    public int tuition;
    public Course.Attendance attendance;
    public Course.Duration duration;

    public CourseSearch() {
    }

    public CourseSearch(String country, String fieldOfStudy, String city, int tuition, Course.Attendance attendance, Course.Duration duration) {
        this.country = country;
        this.fieldOfStudy = fieldOfStudy;
        this.city = city;
        this.tuition = tuition;
        this.attendance = attendance;
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public Course.Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Course.Attendance attendance) {
        this.attendance = attendance;
    }

    public Course.Duration getDuration() {
        return duration;
    }

    public void setDuration(Course.Duration duration) {
        this.duration = duration;
    }
}
