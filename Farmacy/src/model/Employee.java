package model;

import ORM.EmployeeORM;

import javax.persistence.*;

@Entity
@Table(name= "employee")
public class Employee {

    @Id
    private String username;

    @Column
    private String password;

    public Employee(){}


    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String toString(){
        return this.username;
    }

    public boolean checkhAutentification(){

        Employee e = EmployeeORM.findByUsername(this.username);
        if(this.password.compareTo(e.getPassword()) == 0)
            return true;
        return false;
    }

    public boolean isAdmin(){

        return username.equals("admin");
    }


}
