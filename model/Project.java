package model;

public class Project {
    private String studentId;
    private String status; // Passed / Failed

    public Project(String studentId, String status) {
        this.studentId = studentId;
        this.status = status;
    }
    public String getStudentId() { return studentId; }
    public String getStatus() { return status; }
}