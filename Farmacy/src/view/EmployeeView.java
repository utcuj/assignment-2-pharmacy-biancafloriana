package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class EmployeeView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableMedication;
    private DefaultTableModel modelMedication;
    private JButton searchByNameB;
    private JButton seachByManufacturerB;
    private JButton seachByIngredientsB;
    private JButton sellB;
    private JTextField quantityT,searchT;
    private JScrollPane listMedication;


    public EmployeeView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        searchByNameB = new JButton("Seach by name");
        seachByManufacturerB = new JButton("Seach by manufacturer");
        seachByIngredientsB = new JButton("Seach by ingredients");
        sellB = new JButton("Sell");
        quantityT = new JTextField(10);
        searchT = new JTextField(10);
        tableMedication = new JTable();
        listMedication = new JScrollPane(tableMedication);
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listMedication);
        jframe.setContentPane(jpanel);
        jpanel.add(searchT);
        jpanel.add(searchByNameB);
        jpanel.add(seachByManufacturerB);
        jpanel.add(seachByIngredientsB);
        jpanel.add(quantityT);
        jpanel.add(sellB);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        // jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
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

        for (int i = 0; i < colNumber - 1; i++) {
            result[i] = tableMedication.getModel().getValueAt(id, i);
        }

        return result;
    }

    public void addListenerSBN(ActionListener ButtonL) {
        searchByNameB.addActionListener(ButtonL);

    }


    public void addListenerSBM(ActionListener ButtonL) {
        seachByManufacturerB.addActionListener(ButtonL);

    }

    public void addListenerSBI(ActionListener ButtonL) {
        seachByIngredientsB.addActionListener(ButtonL);

    }
    public void addListenerSell(ActionListener ButtonL) {
        sellB.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }




    public void UpdateId(int quantity) {
        modelMedication.setValueAt(quantity, tableMedication.getSelectedRow(), 4);
       // modelMedication.setValueAt(date, tableMedication.getSelectedRow(), 2);
    }

    public String getSeachText() {
        return searchT.getText();
    }

    public void addMedication(Vector medicationV) {
        modelMedication.addRow(medicationV);
    }
}
