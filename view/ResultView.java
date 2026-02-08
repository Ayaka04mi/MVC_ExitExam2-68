package view;

import model.GraduationResult;
import javax.swing.*;
import java.awt.*;

public class ResultView extends JDialog {
    private JLabel lblFinalMessage;

    public ResultView(JFrame parent) {
        super(parent, "3. Result", true);
        setSize(300, 150);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        lblFinalMessage = new JLabel("", SwingConstants.CENTER);
        lblFinalMessage.setFont(new Font("Tahoma", Font.BOLD, 16));

        JButton btnClose = new JButton("successfully recorded");
        btnClose.addActionListener(e -> setVisible(false));

        add(lblFinalMessage, BorderLayout.CENTER);
        add(btnClose, BorderLayout.SOUTH);
    }

    public void showResult(GraduationResult resultObj) {
        lblFinalMessage.setText(resultObj.getResult()); // โชว์ PASS / NOT PASS
        lblFinalMessage.setToolTipText(resultObj.getMessage()); // โชว์เหตุผล

        if ("PASS".equals(resultObj.getResult())) {
            lblFinalMessage.setBackground(Color.GREEN);
            lblFinalMessage.setForeground(Color.BLACK);
        } else {
            lblFinalMessage.setBackground(Color.RED);
            lblFinalMessage.setForeground(Color.WHITE);
        }
        setVisible(true);
    }
}