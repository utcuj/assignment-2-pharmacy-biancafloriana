package model.DAO;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {

    public String create(Employee e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created employee" + e.toString());
        return e.getUsername();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Employee.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List<Employee> read() {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        List<Employee> employee = session.createQuery("FROM Employee").list();
        session.close();
        System.out.println("Found " + employee.size() + " model.Employee");
        return employee;
    }

    public void update(Employee e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Employee em = session.load(Employee.class, e.getUsername());
        em.setUsername(e.getUsername());
        em.setPassword(e.getPassword());

        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + e.toString());

    }

    public void delete(String id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = findByID(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());

    }

    public Employee findByID(String id) {
        Session session = getSessionFactory().openSession();
        Employee e = (Employee) session.load(Employee.class, id);
        session.close();
        return e;
    }

    private List<Employee> findBy(String query) {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Employee> employee = session.createQuery(query).list();
        session.close();
        System.out.println("Found " + employee.size() + " model.Employee");
        return employee;
    }

    public Employee findByUsername(String userName) {

        Session session = getSessionFactory().openSession();
        Employee e = (Employee) session.load(Employee.class, userName);
        session.close();
        return e;
    }
}
