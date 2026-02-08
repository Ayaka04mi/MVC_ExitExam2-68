package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AssessmentView extends JFrame {
    private JLabel lblId, lblName, lblCredit, lblProject;
    private JLabel lblStatusResult; // ตัวแสดงผล "จบ/ไม่จบ"
    private JButton btnConfirm;

    public AssessmentView() {
        setTitle("2. Graduation Readiness Assessment Page ");
        setSize(400, 350);
        setLayout(new GridLayout(7, 1, 10, 10)); // 7 แถว
        setLocationRelativeTo(null);

        // Components
        lblId = new JLabel("-");
        lblName = new JLabel("-");
        lblCredit = new JLabel("-");
        lblProject = new JLabel("-");
        
        // Label แสดงสถานะตัวใหญ่ๆ
        lblStatusResult = new JLabel("Status: -", SwingConstants.CENTER);
        lblStatusResult.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblStatusResult.setOpaque(true);

        btnConfirm = new JButton("Confirm the assessment results");
        btnConfirm.setBackground(Color.LIGHT_GRAY);

        // Add to Frame
        add(new JLabel("=== Educational information ===", SwingConstants.CENTER));
        add(lblId);
        add(lblName);
        add(lblCredit);
        add(lblProject);
        add(lblStatusResult); // ใส่ตรงนี้
        add(btnConfirm);
    }

    public void updateView(String id, String name, int credit, String project, boolean isPass) {
        lblId.setText("  Student ID: " + id);
        lblName.setText("  Name: " + name);
        lblCredit.setText("  Accumulated credits: " + credit + " (criterion 135)");
        lblProject.setText("  Project status: " + project);

        // Logic เปลี่ยนสีและข้อความ
        if (isPass) {
            lblStatusResult.setText("Status: Ready to graduate.");
            lblStatusResult.setBackground(Color.GREEN);
            lblStatusResult.setForeground(Color.BLACK);
        } else {
            lblStatusResult.setText("Status: Failed to meet criteria.");
            lblStatusResult.setBackground(Color.RED);
            lblStatusResult.setForeground(Color.WHITE);
        }
    }

    public void addConfirmListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
    }
}