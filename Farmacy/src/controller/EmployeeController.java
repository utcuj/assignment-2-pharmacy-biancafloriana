package controller;

import model.BLL.MedicationServices;
import model.Medication;
import view.EmployeeView;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class EmployeeController {
    private EmployeeView medicationView;
    private String name;

    public EmployeeController(String name) {

        medicationView = new EmployeeView();
        this.name = name;
        addListenerSBN();
        addListenerSBI();
        addListenerSBM();
        addListenerSellB();


    }

    private void addListenerSBN() {

        ActionListener addButtonL = arg0 -> {
            try {
                String date = medicationView.getSearchText();

                //Medication m = new Medication((String)date[0],(String)date[1],(String)date[2],Integer.valueOf((String)date[3]),Double.valueOf((String)date[4]));

                List<Medication> m = MedicationServices.findByName(date);
                addToView(m);

                //System.out.println(MedicationORM.findByManufacturer("Farmec"));

            } catch (Exception e) {
                medicationView.printMessage("Datele nu sunt valide!");
                //e.printStackTrace();
            }
        };
        medicationView.addListenerSBN(addButtonL);
    }

    private void addListenerSBI() {

        ActionListener addButtonL = arg0 -> {
            try {
                String date = medicationView.getSearchText();

                List<Medication> m = MedicationServices.findByIngredients(date);
                addToView(m);

            } catch (Exception e) {
                medicationView.printMessage("Datele nu sunt valide!");
                //e.printStackTrace();
            }
        };
        medicationView.addListenerSBI(addButtonL);
    }


    private void addListenerSBM() {

        ActionListener addButtonL = arg0 -> {
            try {
                String date = medicationView.getSearchText();

                List<Medication> m = MedicationServices.findByManufacturer(date);
                addToView(m);

            } catch (Exception e) {
                medicationView.printMessage("Datele nu sunt valide!");
                //e.printStackTrace();
            }
        };
        medicationView.addListenerSBM(addButtonL);
    }


    private void addListenerSellB() {

        ActionListener addButtonL = arg0 -> {
            try {
                String quanity = medicationView.getQuantity();
                Object[] date = medicationView.getMedication();

                //System.out.println(date[5]);
                Medication m = new Medication((int) date[0],
                        (String) date[1],
                        (String) date[2],
                        (String) date[3],
                        Integer.valueOf((String) date[4]),
                        Double.valueOf((String) date[5]));

                m.sell(Integer.valueOf(quanity), this.name);
                //Vector newMedication = dateToVector(m);

                medicationView.updateQuantity(m.getQuantity());


            } catch (Exception e) {
                medicationView.printMessage("Datele nu sunt valide!");
               // e.printStackTrace();
            }
        };
        medicationView.addListenerSell(addButtonL);
    }


    private Vector dateToVector(Medication medication) {

        Vector medicationV = new Vector();

        medicationV.add(medication.getId());
        medicationV.add(medication.getName());
        medicationV.add(medication.getIngredients());
        medicationV.add(medication.getManufacturer());
        medicationV.add(String.valueOf(medication.getQuantity()));
        medicationV.add(String.valueOf(medication.getPrice()));

        return medicationV;
    }

    private void addToView(List<Medication> m) {
        for (Medication medication : m) {

            Vector medicationV = dateToVector(medication);
            medicationView.addMedication(medicationV);
            //System.out.println("done");
        }
    }

}
