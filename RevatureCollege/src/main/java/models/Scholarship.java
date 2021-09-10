package models;

public class Scholarship {
    private Integer scholarshipID;
    private Integer studentID;
    private Boolean isApply;
    private Double amount;
    private String decision;

    public Scholarship() {

    }

    public Scholarship(Integer scholarshipID, Integer studentID, Boolean isApply, Double amount, String decision) {
        this.scholarshipID = scholarshipID;
        this.studentID = studentID;
        this.isApply = isApply;
        this.amount = amount;
        this.decision = decision;
    }

    public Scholarship(Integer scholarshipID, Double amount, String decision) {
        this.scholarshipID = scholarshipID;
        this.amount = amount;
        this.decision = decision;
    }

    public Scholarship(Integer scholarshipID, Boolean isApply) {
        this.scholarshipID = scholarshipID;
        this.isApply = isApply;
    }

    public Integer getScholarshipID() {
        return scholarshipID;
    }

    public void setScholarshipID(Integer scholarshipID) {
        this.scholarshipID = scholarshipID;
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
        return "Scholarship ID: " + scholarshipID +
                " | Student ID: " + studentID +
                " | isApply: " + (isApply) +
                " | Award Amount: " + amount +
                " | Decision: " + decision;

    }
}
