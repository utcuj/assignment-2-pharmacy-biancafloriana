package model.conversion;

import model.Register;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertorSale {
    public Register convertFromXML() {
        Register sales = null;
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\Assigment2\\assignment-2-pharmacy-biancafloriana\\register.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            sales = (Register) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Register is loaded!");

        } catch (JAXBException e) {
            System.out.println("Register is empty!");
            return new Register();
            // e.printStackTrace();
        }

        return sales;
    }

    public void convertToXML(Register sales) {
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\Assigment2\\assignment-2-pharmacy-biancafloriana\\register.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(sales, file);


        } catch (JAXBException e) {
           // e.printStackTrace();
            System.out.println("Register could not be saved!");
        }
    }
}
