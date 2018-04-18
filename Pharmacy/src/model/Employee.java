package model;

import model.BLL.EmployeeServices;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private String username;

    @Column
    private String password;

    public Employee() {
    }


    public Employee(String username, String password) throws Exception {
        Validation(username);
        Validation(password);
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        Validation(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        Validation(password);
        this.password = password;

    }


    public String toString() {
        return this.username;
    }

    public boolean checkhAutentification() {

        Employee e = EmployeeServices.findById(this.username);
        if (this.password.compareTo(e.getPassword()) == 0)
            return true;
        return false;
    }

    public boolean isAdmin() {

        return username.equals("admin");
    }

    private void Validation(String s) throws Exception {

        String regex = "^[a-zA-Z0-9]+$";
        if(!s.matches(regex)){
            throw  new Exception();
        }

    }
}
