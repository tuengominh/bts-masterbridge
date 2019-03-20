package co.masterbridge.model;

public class Course {

   private String country;
   private String city;
   private String discipline;
   private long tuition;
   private Attendance attendance = Attendance.FULLTIME;
   private Duration duration = Duration.ONE;

    public Course(String country, String city, String discipline, long tuition, Attendance attendance, Duration duration) {
        this.country = country;
        this.city = city;
        this.discipline = discipline;
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



}
