package co.masterbridge.model;

public class Course {

    private long id;
    //TODO: school_id
    private String country;
    private String name;
    private String city;
    private String fieldOfStudy; //TODO: case sensitive & change to enum type (?)
    private int tuition;
    private Attendance attendance;
    private Duration duration;
    //TODO: Curriculum (binary file), Images (binary file), Teacher's profiles (?), List of Alumnus (Users studying at that school)

    public enum Duration {SIX_MONTHS, NINE_MONTHS, ONE_YEAR, TWO_YEAR} //TODO: How to store integers in enum manner?

    public enum Attendance {FULL_TIME, PART_TIME, ONLINE}

    public Course() {
    }

    public Course(long id, String country, String name, String city, String fieldOfStudy, int tuition, Attendance attendance, Duration duration) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.city = city;
        this.fieldOfStudy = fieldOfStudy;
        this.tuition = tuition;
        this.attendance = attendance;
        this.duration = duration;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
