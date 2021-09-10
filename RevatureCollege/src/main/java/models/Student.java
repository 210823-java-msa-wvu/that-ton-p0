package models;

public class Student {
    private Integer studentID;
    private String firstName;
    private String lastName;
    private String studentEmail;
    private String studentMajor;

    public Student () {

    }

    public Student(Integer studentID, String firstName, String lastName, String studentEmail, String studentMajor) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentEmail = studentEmail;
        this.studentMajor = studentMajor;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
                " | First Name: " + firstName +
                " | Last Name: " + lastName +
                " | Email: " + studentEmail +
                " | Major: " + studentMajor;

    }
}
