package co.masterbridge.website.model;

import java.util.List;

public class CourseSearch {

    public String country;
    public List<String> fieldOfStudy;
    public String city;
    public int tuition;
    public Course.Attendance attendance;
    public Course.Duration duration;

    public CourseSearch() {}

    public CourseSearch(String country, List<String> fieldOfStudy, String city, int tuition, Course.Attendance attendance, Course.Duration duration) {
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

    public List<String> getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(List<String> fieldOfStudy) {
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
