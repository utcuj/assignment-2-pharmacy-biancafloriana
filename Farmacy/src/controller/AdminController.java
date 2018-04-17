package controller;

import view.AdminChooseView;

import java.awt.event.ActionListener;

public class AdminController {

    private AdminChooseView adminChooseView = new AdminChooseView();

    AdminController() {

        addListenerMedication();
        addListenerEmployee();

    }

    private void addListenerEmployee() {
        ActionListener addButtonL = arg0 -> {
            new AdminEmployeeController();
            adminChooseView.dispose();

        };

        adminChooseView.addListenerEmployeeB(addButtonL);
    }

    private void addListenerMedication() {

        ActionListener addButtonL = arg0 -> {
            new AdminMedicationController();
            adminChooseView.dispose();

        };

        adminChooseView.addListenerMedicationB(addButtonL);

    }
}
