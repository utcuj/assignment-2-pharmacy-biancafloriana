package controller;


import model.Employee;
import view.EmployeeView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private LoginView loginView;

    private LoginController() {
        loginView = new LoginView();
        addListener();
    }

    private void addListener() {

        ActionListener ButtonL = arg0 -> {
            try {
                Object[] date = loginView.getInfo();
                Employee e = new Employee((String) date[0], (String) date[1]);
                if (e.checkhAutentification()) {

                    if (e.isAdmin()) {
                        new AdminController();
                    } else {
                        new EmployeeController(e.getUsername());
                        System.out.println("loginSucced");
                    }
                    loginView.dispose();

                }

            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Nu s-a putut efectua logarea!");
            }
        };
        loginView.addListener(ButtonL);
    }

    public static void main(String[] args) {

        new LoginController();
    }

}
