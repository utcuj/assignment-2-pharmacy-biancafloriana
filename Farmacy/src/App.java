import ORM.MedicationORM;
import model.Medication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public static void main(String[] args) {

        MedicationORM medicationORM = new MedicationORM();
        Medication em1 = new Medication("Paracetamol1","Paracetamol","Paracetamol",25,23.10);
        //model.Medication em2 = new model.Medication("John Aces", 32);
        //model.Medication em3 = new model.Medication("Ian Young", 29);

        /*System.out.println(" =======CREATE =======");
        //create(em1);
        //create(em2);
        //create(em3);
        System.out.println(" =======READ =======");
        */List<Medication> ems1 = medicationORM.read();
        for(Medication e: ems1) {
            System.out.println(e.toString());
            e.setManufacturer("Rumox");
            medicationORM.update(e);
        }
       // medicationORM.update(em1);
    }

}
