package model;
import java.util.*;

public class DataService {
    private List<Student> students = new ArrayList<>();
    private List<Credit> credits = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<GraduationResult> results = new ArrayList<>();

    public DataService() {
        // Mock Data: สร้างข้อมูลตัวอย่าง
        // 1. คนนี้ผ่าน (เกรดถึง, โปรเจคผ่าน)
        students.add(new Student("66001", "Somying Jingjai", "Studying"));
        credits.add(new Credit("66001", 140)); 
        projects.add(new Project("66001", "Passed"));

        // 2. คนนี้ไม่ผ่าน (เกรดไม่ถึง)
        students.add(new Student("66002", "Somchai Saisamoe", "Studying"));
        credits.add(new Credit("66002", 120)); 
        projects.add(new Project("66002", "Passed"));

        // 3. คนนี้ไม่ผ่าน (โปรเจคตก)
        students.add(new Student("66003", "Peter Parker", "Studying"));
        credits.add(new Credit("66003", 138)); 
        projects.add(new Project("66003", "Failed"));
    }

    public List<Student> getAllStudents() { return students; }

    public int getCreditAmount(String id) {
        return credits.stream().filter(c -> c.getStudentId().equals(id))
               .findFirst().map(Credit::getTotalCredits).orElse(0);
    }

    public String getProjectStatus(String id) {
        return projects.stream().filter(p -> p.getStudentId().equals(id))
               .findFirst().map(Project::getStatus).orElse("N/A");
    }

    // *** Logic สำคัญ: เช็คว่าจบหรือไม่ ***
    public boolean checkQualification(String id) {
        int c = getCreditAmount(id);
        String p = getProjectStatus(id);
        return (c >= 135) && "Passed".equalsIgnoreCase(p);
    }

    public GraduationResult assessStudent(String id) {
        boolean passed = checkQualification(id);
        String resultStr = passed ? "PASS" : "NOT PASS";
        String msg = passed ? "Graduation approved." : "Did not meet the criteria";

        // สร้าง Object ผลลัพธ์
        GraduationResult result = new GraduationResult(id, resultStr, msg);
        
        // บันทึกลง List
        results.add(result);
        System.out.println("Record Result: " + result.toString());
        
        return result;
    }
}