package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EmployeeView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableMedication;
    private DefaultTableModel modelMedication;
    private JButton searchByNameB;
    private JButton searchByManufacturerB;
    private JButton searchByIngredientsB;
    private JButton sellB;
    private JTextField quantityT, searchT;
    private JScrollPane listMedication;


    public EmployeeView() {
        jframe = new JFrame();
        jpanel = new JPanel();

        searchByNameB = new JButton("Search by name");
        searchByManufacturerB = new JButton("Search by manufacturer");
        searchByIngredientsB = new JButton("Search by ingredients");
        sellB = new JButton("Sell");

        quantityT = new JTextField(10);
        searchT = new JTextField(10);

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
        jpanel.add(searchT);
        jpanel.add(searchByNameB);
        jpanel.add(searchByManufacturerB);
        jpanel.add(searchByIngredientsB);
        jpanel.add(quantityT);
        jpanel.add(sellB);
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

    public void addListenerSBN(ActionListener ButtonL) {
        searchByNameB.addActionListener(ButtonL);

    }


    public void addListenerSBM(ActionListener ButtonL) {
        searchByManufacturerB.addActionListener(ButtonL);

    }

    public void addListenerSBI(ActionListener ButtonL) {
        searchByIngredientsB.addActionListener(ButtonL);

    }

    public void addListenerSell(ActionListener ButtonL) {
        sellB.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public String getSearchText() {
        initTable();
        return searchT.getText();
    }

    public String getQuantity() {
        return quantityT.getText();
    }

    public void addMedication(Vector medicationV) {
        modelMedication.addRow(medicationV);
    }

    public void updateQuantity(Integer quantity) {
        modelMedication.setValueAt(quantity, tableMedication.getSelectedRow(), 4);
    }
}
