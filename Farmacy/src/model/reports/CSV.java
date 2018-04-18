package model.reports;

import model.BLL.MedicationServices;
import model.Medication;

import java.io.*;
import java.util.List;

public class CSV implements Report {
    @Override
    public void generateReport() {


        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("F:\\Facultate\\An III\\sem2\\PS\\Assigment2\\assignment-2-pharmacy-biancafloriana\\Report.csv"));

            List<Medication> meds = MedicationServices.getOutOfStock();

            StringBuilder sb = new StringBuilder();
            sb.append("Medication");
            sb.append(',');
            sb.append("Ingredients");
            sb.append(',');
            sb.append("Manufacturer");
            sb.append('\n');

            for (Medication m : meds) {
                sb.append(m.getName());
                sb.append(',');
                sb.append(m.getIngredients());
                sb.append(',');
                sb.append(m.getManufacturer());
                sb.append('\n');
            }

            pw.write(sb.toString());
            pw.close();
            System.out.println("done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
