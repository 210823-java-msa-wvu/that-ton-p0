package models;

public class Tuition {
    private Integer studentID;
    private Double tuition;
    private Double balance;

    public Tuition() {

    }

    public Tuition(Integer studentID, Double tuition, Double balance) {
        this.studentID = studentID;
        this.tuition = tuition;
        this.balance = balance;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Double getTuition() {
        return tuition;
    }

    public void setTuition(Double tuition) {
        this.tuition = tuition;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Tuition{" +
                "id=" + studentID +
                ", tuition='" + tuition + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
