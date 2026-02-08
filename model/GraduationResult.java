package model;

public class GraduationResult {
    private String studentId;
    private String result;   // เช่น "PASS", "NOT PASS"
    private String message;  // เช่น "หน่วยกิตไม่ครบ", "ผ่านเกณฑ์"

    public GraduationResult(String studentId, String result, String message) {
        this.studentId = studentId;
        this.result = result;
        this.message = message;
    }

    public String getStudentId() { return studentId; }
    public String getResult() { return result; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return result + " (" + message + ")";
    }
}