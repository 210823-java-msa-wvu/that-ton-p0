package models;

public class Scholarship {
    private Integer studentID;
    private Boolean isApply;
    private Double amount;
    private String decision;

    public Scholarship() {

    }

    public Scholarship(Integer studentID, Boolean isApply, Double amount, String decision) {
        this.studentID = studentID;
        this.isApply = isApply;
        this.amount = amount;
        this.decision = decision;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Boolean getApply() {
        return isApply;
    }

    public void setApply(Boolean apply) {
        isApply = apply;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "id=" + studentID +
                ", isApply='" + (isApply) + '\'' +
                ", amount='" + amount + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }
}
