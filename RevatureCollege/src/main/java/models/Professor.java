package models;

public class Professor {
    private Integer professorID;
    private String firstName;
    private String lastName;
    private String profEmail;


    public Professor() {

    }

    public Professor(Integer professorID, String firstName, String lastName, String profEmail) {
        this.professorID = professorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profEmail = profEmail;
    }

    public Integer getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Integer professorID) {
        this.professorID = professorID;
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

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + professorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + profEmail + '\'' +
                '}';
    }
}
