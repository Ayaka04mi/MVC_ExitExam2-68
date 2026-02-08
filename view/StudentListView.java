package view;

import model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentListView extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnGoToAssess;

    public StudentListView() {
        setTitle("1. Student List");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ตาราง
        String[] cols = {"Student ID", "Full Name", "Status"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ปุ่ม
        JPanel panel = new JPanel();
        btnGoToAssess = new JButton("Check and Evaluate");
        btnGoToAssess.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(btnGoToAssess);
        add(panel, BorderLayout.SOUTH);
    }

    public void setStudentList(List<Student> students) {
        model.setRowCount(0);
        for (Student s : students) {
            model.addRow(new Object[]{s.getId(), s.getFullName(), s.getStatus()});
        }
    }

    public String getSelectedStudentId() {
        int row = table.getSelectedRow();
        return (row != -1) ? model.getValueAt(row, 0).toString() : null;
    }

    public void addAssessListener(ActionListener listener) {
        btnGoToAssess.addActionListener(listener);
    }
}