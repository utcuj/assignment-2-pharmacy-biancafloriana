package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminMedicationView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableMedication;
    private DefaultTableModel modelMedication;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JButton csvReport;
    private JButton pdfReport;
    private JScrollPane listMedication;


    public AdminMedicationView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        csvReport = new JButton("Report csv");
        pdfReport = new JButton("Report pdf");
        tableMedication = new JTable();
        tableMedication.setRowHeight(20);
        listMedication = new JScrollPane(tableMedication);
        listMedication.setPreferredSize(new Dimension(750, 400));
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listMedication);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jpanel.add(csvReport);
        jpanel.add(pdfReport);
        jframe.setLocation(600, 200);
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("id");
        cols.add("name");
        cols.add("ingredients");
        cols.add("manufacturer");
        cols.add("quantity");
        cols.add("price");

        modelMedication = new DefaultTableModel(null, cols) {
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        tableMedication.setModel(modelMedication);
    }

    public Object[] getMedication() {

        int id = tableMedication.getSelectedRow();
        int colNumber = modelMedication.getColumnCount();
        Object[] result = new Object[colNumber];

        for (int i = 0; i < colNumber; i++) {
            result[i] = tableMedication.getModel().getValueAt(id, i);

        }
        return result;
    }

    public void addListenerAddB(ActionListener ButtonL) {
        addButton.addActionListener(ButtonL);

    }

    public void addListenerDeleteB(ActionListener ButtonL) {
        deleteButton.addActionListener(ButtonL);

    }

    public void addListenerCSVB(ActionListener ButtonL) {
        csvReport.addActionListener(ButtonL);

    }

    public void addListenerPDFB(ActionListener ButtonL) {
        pdfReport.addActionListener(ButtonL);

    }

    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void updateRow(Vector medication) {
        int id = tableMedication.getSelectedRow();
        modelMedication.removeRow(id);
        modelMedication.addRow(medication);
        modelMedication.moveRow(tableMedication.getRowCount() - 1, tableMedication.getRowCount() - 1, id);
    }

    public void addMedication(Vector medicationV) {
        modelMedication.addRow(medicationV);
    }

    public void addNewRow() {
        modelMedication.addRow(new Vector());
    }

    public void removeRow() {
        modelMedication.removeRow(tableMedication.getSelectedRow());
    }
}
