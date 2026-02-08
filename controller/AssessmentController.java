package controller;

import model.DataService;
import model.Student;
import view.StudentListView;
import view.AssessmentView;
import view.ResultView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssessmentController {
    private DataService model;
    private StudentListView listView;     // View 1
    private AssessmentView assessView;    // View 2
    private ResultView resultView;        // View 3

    private String currentStudentId;      // จำไว้ว่ากำลังทำรายการให้ใคร

    public AssessmentController(DataService model, StudentListView listView) {
        this.model = model;
        this.listView = listView;
        
        // สร้าง View ย่อยรอไว้
        this.assessView = new AssessmentView();
        this.resultView = new ResultView(listView);

        // 1. เริ่มต้น: โหลดข้อมูลลงตาราง
        listView.setStudentList(model.getAllStudents());

        // 2. Event: กดปุ่มที่หน้าแรก -> ไปหน้าประเมิน
        listView.addAssessListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepareAssessment();
            }
        });

        // 3. Event: กดปุ่มที่หน้าประเมิน -> บันทึกและโชว์ผล
        assessView.addConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmAssessment();
            }
        });
    }

    // Logic: เตรียมข้อมูลและเปิดหน้า 2
    private void prepareAssessment() {
        currentStudentId = listView.getSelectedStudentId();
        
        if (currentStudentId == null) {
            JOptionPane.showMessageDialog(listView, "กรุณาเลือกนักศึกษาจากตารางก่อน!");
            return;
        }

        // ดึงข้อมูล
        Student s = model.getAllStudents().stream().filter(st -> st.getId().equals(currentStudentId)).findFirst().get();
        int credit = model.getCreditAmount(currentStudentId);
        String project = model.getProjectStatus(currentStudentId);
        
        // เช็คเงื่อนไข (Pass/Fail)
        boolean isPass = model.checkQualification(currentStudentId);

        // ส่งข้อมูลไปหน้า View 2 และสั่งให้แสดงผล
        assessView.updateView(s.getId(), s.getFullName(), credit, project, isPass);
        assessView.setVisible(true);
    }

    // Logic: บันทึกและเปิดหน้า 3
    private void confirmAssessment() {
        // เรียกใช้ฟังก์ชันใหม่ assessStudent ที่คืนค่าเป็น GraduationResult
        model.GraduationResult resultObj = model.assessStudent(currentStudentId);

        // ปิดหน้า 2 -> เปิดหน้า 3
        assessView.setVisible(false);
        
        // ส่ง Object ผลลัพธ์ไปแสดงที่หน้า 3
        resultView.showResult(resultObj);
    }
}