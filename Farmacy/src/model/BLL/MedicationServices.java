package model.BLL;

import model.DAO.MedicationDAO;
import model.Medication;

import java.util.List;

public class MedicationServices {

    public static List<Medication> findByName(String date) {

        return new MedicationDAO().findByName(date);
    }

    public static List<Medication> findByIngredients(String date) {

        return new MedicationDAO().findByIngredients(date);
    }

    public static List<Medication> findByManufacturer(String date) {

        return new MedicationDAO().findByManufacturer(date);
    }

    public static void update(Medication medication) {

        new MedicationDAO().update(medication);
    }

    public static Integer insert(Medication medication) {
        return new MedicationDAO().create(medication);
    }

    public static void delete(Integer s) {
        new MedicationDAO().delete(s);
    }

    public static List<Medication> findAll() {
        return new MedicationDAO().read();
    }

    public static List<Medication> getOutOfStock() {
        return new MedicationDAO().findOutOfStock();
    }
}