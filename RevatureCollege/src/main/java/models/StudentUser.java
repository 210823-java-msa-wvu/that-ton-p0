package models;

public class StudentUser {
    private Integer studentID;
    private String studentEmail;
    private String studentPw;

    public StudentUser() {
    }

    public StudentUser(String studentEmail, String studentPw) {
        this.studentEmail = studentEmail;
        this.studentPw = studentPw;
    }

    public StudentUser(Integer studentID, String studentEmail, String studentPw) {
        this.studentID = studentID;
        this.studentEmail = studentEmail;
        this.studentPw = studentPw;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPw() {
        return studentPw;
    }

    public void setStudentPw(String studentPw) {
        this.studentPw = studentPw;
    }

    @Override
    public String toString() {
        return "StudentUser{" +
                "id=" + studentID +
                ", username='" + studentEmail + '\'' +
                ", password='" + studentPw + '\'' +
                '}';
    }
}
