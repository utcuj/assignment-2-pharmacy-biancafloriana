package model.conversion;

import model.Employee;
import model.IUser;
import model.Sale;
import sun.java2d.pipe.RegionIterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertorSale  {
    public Register convertFromXML(){
        Register sales = null;
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\register.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            sales = (Register) jaxbUnmarshaller.unmarshal(file);
            // System.out.println(user);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return sales;
    }

    public void ConvertToXML(Register sales) {
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\register.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(sales, file);
            //jaxbMarshaller.marshal(user, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
