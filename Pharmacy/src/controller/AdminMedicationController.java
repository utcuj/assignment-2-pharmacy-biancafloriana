package controller;


import model.BLL.MedicationServices;
import model.Medication;
import model.reports.RaportBuilder;
import view.AdminMedicationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AdminMedicationController {

    private AdminMedicationView adminMedicationView;

    AdminMedicationController() {
        adminMedicationView = new AdminMedicationView();
        listMedication();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();
        addListenerCSVB();
        addListenerPDFB();


    }

    private void addListenerAddB() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = adminMedicationView.getMedication();

                    if (date[0] != null) {
                        Medication m = new Medication((int) date[0],
                                (String) date[1],
                                (String) date[2],
                                (String) date[3],
                                Integer.valueOf((String) date[4]),
                                Double.valueOf((String) date[5]));

                        MedicationServices.update(m);
                        adminMedicationView.updateRow(dateToVector(m));
                    } else {
                        Medication m = new Medication(
                                (String) date[1],
                                (String) date[2],
                                (String) date[3],
                                Integer.valueOf((String) date[4]),
                                Double.valueOf((String) date[5]));

                        MedicationServices.insert(m);
                        adminMedicationView.updateRow(dateToVector(m));

                    }

                } catch (Exception e) {
                    adminMedicationView.printMessage("Datele nu sunt valide!");
                    ////e.printStackTrace();
                }
            }
        };
        adminMedicationView.addListenerAddB(addButtonL);
    }


    private Vector dateToVector(Medication medication) {

        Vector medicationDate = new Vector();

        medicationDate.add(medication.getId());
        medicationDate.add(medication.getName());
        medicationDate.add(medication.getIngredients());
        medicationDate.add(medication.getManufacturer());
        medicationDate.add(String.valueOf(medication.getQuantity()));
        medicationDate.add(String.valueOf(medication.getPrice()));

        return medicationDate;
    }

    private void addListenerNewB() {

        ActionListener ButtonL = arg0 -> {
            try {
                adminMedicationView.addNewRow();
            } catch (Exception e) {
                adminMedicationView.printMessage("Nu am putut adauga un rand nou in tabel!");
                //e.printStackTrace();
            }
        };

        adminMedicationView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = arg0 -> {
            try {
                Object[] date = adminMedicationView.getMedication();
                if (date != null) {
                    MedicationServices.delete((int) date[0]);
                    adminMedicationView.removeRow();
                }
            } catch (Exception e) {
                adminMedicationView.printMessage("Nu s-a putut face sterggerea!");

            }
        };
        adminMedicationView.addListenerDeleteB(ButtonL);
    }


    private void listMedication() {

        List<Medication> medList = MedicationServices.findAll();

        for (Medication med : medList) {
            Vector medV = dateToVector(med);
            adminMedicationView.addMedication(medV);
        }
    }

    private void addListenerCSVB() {

        ActionListener ButtonL = arg0 -> {
            try {
                RaportBuilder.getReport("CSV");

            } catch (Exception e) {
                adminMedicationView.printMessage("Nu s-a putut genera raportul!");

            }

        };
        adminMedicationView.addListenerCSVB(ButtonL);
    }

    private void addListenerPDFB() {

        ActionListener ButtonL = arg0 -> {
            try {
                System.out.println("Generating report!");
                RaportBuilder.getReport("PDF");

            } catch (Exception e) {
               //e.printStackTrace();
                adminMedicationView.printMessage("Nu s-a putut genera raportul!");

            }

        };
        adminMedicationView.addListenerPDFB(ButtonL);

    }
}

