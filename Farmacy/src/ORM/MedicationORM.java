package ORM;

import model.Employee;
import model.Medication;

import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class MedicationORM {

    private static Integer create(Medication m) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + m.toString());
        return m.getId();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Medication.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public static List<Medication> read() {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        List<Medication> medications = session.createQuery("FROM Medication").list();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public static void update(Medication m) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Medication em = session.load(Medication.class, m.getId());
        em.setName(m.getName());
        em.setIngredients(m.getIngredients());
        em.setManufacturer(m.getManufacturer());
        em.setQuantity(m.getQuantity());
        em.setPrice(m.getPrice());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + m.toString());

    }

    public static void delete(Integer id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Medication m = findByID(id);
        session.delete(m);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + m.toString());

    }

    public static Medication findByID(Integer id) {
        Session session = getSessionFactory().openSession();
        Medication m = (Medication) session.load(Medication.class, id);
        session.close();
        return m;
    }

    private static List<Medication> findBy(String query) {
        Session session = getSessionFactory().openSession();

                System.out.println(query);
                //Medication m = (Medication) session.createQuery(query);
                //System.out.println(m);
        String name = "paracetamol";
        List<Medication> medications = session.createQuery("FROM Medication where Medication.name = name").list();
        session.close();
        System.out.println("Found " + medications.size() + " model.Medication");
        return medications;
    }

    public static List<Medication> findByName(String nam) {
       return findBy("FROM Medication where Medication.name = Paracetamol");

        /*Session session = getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.eq("name", nam));
        List results = cr.list();

        return results;*/
    }

    public static List<Medication> findByIngredients(String ingredients) {

        return findBy("FROM Medication where Medication.ingredients = " + ingredients);
    }

    public static List<Medication> findByManufacturer(String manufacturer) {

        return findBy("FROM Medication where Medication.manufacturer = " + manufacturer);
    }

}
