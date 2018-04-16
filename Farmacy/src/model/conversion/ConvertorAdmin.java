package model.conversion;

import model.Admin;
import model.IUser;
import model.conversion.ConvertorXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertorAdmin implements ConvertorXML {
    @Override
    public IUser convertFromXML() {
        Admin user = null;
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\admin.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Admin.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            user = (Admin)jaxbUnmarshaller.unmarshal(file);
           // System.out.println(user);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void ConvertToXML(IUser user) {
        /*UserFactory userFactory = new UserFactory();
        IUser user = userFactory.getUser("ADMIN");

        user.setUsername("bianca");
        user.setPassword("1234");
        */
        try {

            File file = new File("F:\\Facultate\\An III\\sem2\\PS\\assignment-2-pharmacy-biancafloriana\\admin.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Admin.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(user, file);
            //jaxbMarshaller.marshal(user, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



}
