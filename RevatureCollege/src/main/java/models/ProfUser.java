package models;

public class ProfUser {
    private Integer professorID;
    private String profEmail;
    private String profPw;

    public ProfUser() {
    }

    public ProfUser(String profEmail, String profPw) {
        this.profEmail = profEmail;
        this.profPw = profPw;
    }

    public ProfUser(Integer professorID, String profEmail, String profPw) {
        this.professorID = professorID;
        this.profEmail = profEmail;
        this.profPw = profPw;
    }

    public Integer getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Integer professorID) {
        this.professorID = professorID;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }

    public String getProfPw() {
        return profPw;
    }

    public void setProfPw(String profPw) {
        this.profPw = profPw;
    }

    @Override
    public String toString() {
        return "ProfUser{" +
                "id=" + professorID +
                ", username='" + profEmail + '\'' +
                ", password='" + profPw + '\'' +
                '}';
    }
}
