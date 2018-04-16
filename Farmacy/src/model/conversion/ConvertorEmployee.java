package model.conversion;

import model.Employee;
import model.IUser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertorEmployee {
   /* public IUser convertFromXML(){
        Employee user = null;
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\employee.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            user = (Employee)jaxbUnmarshaller.unmarshal(file);
            // System.out.println(user);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void ConvertToXML(IUser user) {
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\employee.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(user, file);
            //jaxbMarshaller.marshal(user, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/
}
