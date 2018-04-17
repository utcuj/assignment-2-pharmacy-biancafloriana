package model.reports;

import model.reports.CSV;
import model.reports.PDF;

public class RaportBuilder {

    public static void getReport(String type) {


        if (type.compareTo("CSV") == 0) {

            new CSV().generateReport();

        } else {

            new PDF().generateReport();

        }

    }
}
