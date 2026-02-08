package model;

public class Credit {
    private String studentId;
    private int totalCredits;

    public Credit(String studentId, int totalCredits) {
        this.studentId = studentId;
        this.totalCredits = totalCredits;
    }
    public String getStudentId() { return studentId; }
    public int getTotalCredits() { return totalCredits; }
}