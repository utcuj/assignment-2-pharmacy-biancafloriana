package controller;

import ORM.MedicationORM;
import model.Employee;
import model.Medication;
import view.EmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

public class EmployeeController {
    private EmployeeView medicationView;


    public EmployeeController(Employee e) {

        medicationView = new EmployeeView();

        addListenerSBN();


    }

    private void addListenerSBN() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String date = medicationView.getSeachText();

                    //Medication m = new Medication((String)date[0],(String)date[1],(String)date[2],Integer.valueOf((String)date[3]),Double.valueOf((String)date[4]));
                    
                    List<Medication> m = MedicationORM.findByName("Paracetamol");

                    for (Medication medication : m) {
                        Vector medicationV = new Vector();

                        medicationV.add(medication.getId());
                        medicationV.add(medication.getName());
                        medicationV.add(medication.getManufacturer());
                        medicationV.add(medication.getIngredients());
                        medicationV.add(String.valueOf(medication.getQuantity()));
                        medicationV.add(String.valueOf(medication.getPrice()));

                        medicationView.addMedication(medicationV);
                        System.out.println("done");
                    }

                    //System.out.println(MedicationORM.findByManufacturer("Farmec"));

                } catch (Exception e) {
                    medicationView.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        medicationView.addListenerSBN(addButtonL);
    }


   /* private void addListenerNewB() {

        ActionListener ButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    medicationView.addNewRow();
                } catch (Exception e) {
                    medicationView.printMessage("Nu am putut adauga un rand nou!");
                    e.printStackTrace();
                }
            }
        };
        medicationView.addListenerNewRB(ButtonL);
    }


    private void ListEmployee() {
        EmployeeMapper employeeMapper = new EmployeeMapper();
        List<Employee> employeeList = employeeMapper.findAll(reservationId);

        for (Employee employee : employeeList) {
            Vector medicationV = new Vector();

            medicationV.add(employee.getIdEmployee());
            medicationV.add(String.valueOf(employee.getEmployee()));
            medicationV.add(String.valueOf(employee.getDate()));

            medicationView.addEmployee(medicationV);
        }
    }*/

}
