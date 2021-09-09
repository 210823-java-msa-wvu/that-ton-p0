package models;

public class Schedule {
    private Integer studentID;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    public Schedule() {

    }

    public Schedule(Integer studentID, String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.studentID = studentID;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + studentID +
                ", mon='" + monday + '\'' +
                ", tue='" + tuesday + '\'' +
                ", wed='" + wednesday + '\'' +
                ", thu='" + thursday + '\'' +
                ", fri='" + friday + '\'' +
                '}';
    }
}
