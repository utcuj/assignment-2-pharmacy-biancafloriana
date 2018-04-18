package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminChooseView {

    private JButton medicationB;
    private JButton employeeB;
    private JFrame jframe;
    private JPanel jpanel;

    public AdminChooseView() {

        jframe = new JFrame();
        jpanel = new JPanel();
        medicationB = new JButton("Medications");
        employeeB = new JButton("Employee");

        init();
    }

    private void init() {

        jframe.setContentPane(jpanel);
        jpanel.add(employeeB);
        jpanel.add(medicationB);
        jframe.setLocation(600, 200);
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public void addListenerMedicationB(ActionListener ButtonL) {
        medicationB.addActionListener(ButtonL);

    }

    public void addListenerEmployeeB(ActionListener ButtonL) {
        employeeB.addActionListener(ButtonL);

    }

    public void dispose() {
        jframe.dispose();
    }
}
