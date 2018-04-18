package model.reports;

import model.BLL.MedicationServices;
import model.Medication;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class PDF implements Report {
    @Override
    public void generateReport() {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        List<Medication> meds = MedicationServices.getOutOfStock();

        PDPageContentStream contentStream = null;
        try {
            contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.beginText();

            contentStream.newLineAtOffset(25, 700);
            contentStream.setLeading(14.0f);
            StringBuilder sb = new StringBuilder();
            String indent = "           ";
            sb.append("Medication");
            sb.append(indent);
            sb.append("Ingredients");
            sb.append(indent);
            sb.append("Manufacturer");
            contentStream.showText(sb.toString());
            contentStream.newLine();
            for (Medication m : meds) {

                contentStream.showText(m.getName() + indent + m.getIngredients() + indent+m.getManufacturer());
                contentStream.newLine();
            }


            contentStream.endText();
            contentStream.close();

            document.save("F:\\Facultate\\An III\\sem2\\PS\\Assigment2\\assignment-2-pharmacy-biancafloriana\\Report.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Report generated!");
    }
}
