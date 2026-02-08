package model;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String department;
    private String faculty;
    private String status; 

    public Student(String id, String fName, String lName, String dept, String fac, String status) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.department = dept;
        this.faculty = fac;
        this.status = status;
    }
    public Student(String id, String name, String status) {
        this.id = id;
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getStatus() { return status; }
    public String getDepartment() { return department; }
    public String getFaculty() { return faculty; }

    
}