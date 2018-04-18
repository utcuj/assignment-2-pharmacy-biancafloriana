package model.DAO;

import model.Medication;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MedicationDAO {

    public Integer create(Medication m) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + m.toString());
        return m.getId();
    }


    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Medication.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List<Medication> read() {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        List<Medication> medications = session.createQuery("FROM Medication").list();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public void update(Medication m) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Medication em = session.load(Medication.class, m.getId());
        try {
            em.setName(m.getName());
            em.setIngredients(m.getIngredients());
            em.setManufacturer(m.getManufacturer());
            em.setQuantity(m.getQuantity());
            em.setPrice(m.getPrice());
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("Nu s-a putut face update!");
        }

        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + m.toString());

    }

    public void delete(Integer id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Medication m = findByID(id);
        session.delete(m);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + m.toString());

    }

    private Medication findByID(Integer id) {
        Session session = getSessionFactory().openSession();
        Medication m = session.load(Medication.class, id);
        session.close();
        return m;
    }

    /*private  List<Medication> findBy(String name) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM Medication where name =:name");
        query.setParameter("name",name);

        List<Medication> medications = query.getResultList();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }*/

    public List<Medication> findByName(String name) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM Medication where name =:name");
        query.setParameter("name", name);

        List<Medication> medications = query.getResultList();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public List<Medication> findOutOfStock() {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM Medication where quantity = 0");


        List<Medication> medications = query.getResultList();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public List<Medication> findByIngredients(String ingredients) {

        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM Medication where ingredients like CONCAT('%',?1,'%')");
        query.setParameter(1, ingredients);

        List<Medication> medications = query.getResultList();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public List<Medication> findByManufacturer(String manufacturer) {

        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("FROM Medication where manufacturer =:manufacturer");
        query.setParameter("manufacturer", manufacturer);

        List<Medication> medications = query.getResultList();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

}
