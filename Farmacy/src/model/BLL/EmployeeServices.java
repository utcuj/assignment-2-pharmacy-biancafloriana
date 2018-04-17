package model.BLL;

import model.DAO.EmployeeDAO;
import model.Employee;

import java.util.List;

public class EmployeeServices {
    public static Employee findById(String id) {

        return new EmployeeDAO().findByID(id);
    }

    public static void insert(Employee m) {

        new EmployeeDAO().create(m);

    }

    public static void update(Employee m) {

        new EmployeeDAO().update(m);
    }

    public static void delete(String s) {
        new EmployeeDAO().delete(s);
    }

    public static List<Employee> findAll() {

        return new EmployeeDAO().read();
    }
}
