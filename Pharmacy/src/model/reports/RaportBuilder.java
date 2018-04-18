package model.reports;



public class RaportBuilder {

    public static void getReport(String type) {


        if (type.compareTo("CSV") == 0) {

            new CSV().generateReport();

        } else {

            new PDF().generateReport();

        }

    }
}
