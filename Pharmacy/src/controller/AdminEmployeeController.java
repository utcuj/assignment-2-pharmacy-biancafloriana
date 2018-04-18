package controller;

import model.BLL.EmployeeServices;
import model.Employee;
import view.AdminEmployeeView;


import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AdminEmployeeController {

    private AdminEmployeeView adminEmployeeView;

    AdminEmployeeController() {
        adminEmployeeView = new AdminEmployeeView();
        listEmployee();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();


    }

    private void addListenerAddB() {

        ActionListener addButtonL = arg0 -> {
            try {
                Object[] date = adminEmployeeView.getUser();

                if (date[0] != null) {
                    try {
                        EmployeeServices.findById((String) date[0]);
                        EmployeeServices.update(new Employee((String) date[0], (String) date[1]));
                    } catch (Exception e) {

                        if ((int) date[3] >= (int) date[2]) {
                            EmployeeServices.insert(new Employee((String) date[0], (String) date[1]));
                        } else {
                            adminEmployeeView.printMessage("Username-ul nu poate fi modificat!");
                        }
                    }
                    // System.out.println(date[3] + " " + date[2]);

                }
            } catch (Exception e) {
                adminEmployeeView.printMessage("Datele nu sunt valide!");
               //e.printStackTrace();
            }
        };
        adminEmployeeView.addListenerAddB(addButtonL);
    }


    private void addListenerNewB() {

        ActionListener ButtonL = arg0 -> {
            try {
                adminEmployeeView.addNewRow();
            } catch (Exception e) {
                adminEmployeeView.printMessage("Nu am putut adauga un rand nou in tabel!");
                //e.printStackTrace();
            }
        };

        adminEmployeeView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = arg0 -> {
            try {
                Object[] date = adminEmployeeView.getUser();

                if (date != null) {
                    EmployeeServices.delete((String) date[0]);
                    adminEmployeeView.removeRow();
                }
            } catch (Exception e) {
                adminEmployeeView.printMessage("Nu s-a putut face stergerea!");

            }
        };
        adminEmployeeView.addListenerDeleteB(ButtonL);
    }


    private void listEmployee() {

        List<Employee> userList = EmployeeServices.findAll();

        for (Employee user : userList) {
            Vector<String> userV = new Vector();

            userV.add(user.getUsername());
            userV.add(user.getPassword());

            adminEmployeeView.addUser(userV);
        }
    }


}


