package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Admin  implements IUser {

    private static Admin instance = new Admin();

    private final Integer id = 0;
    private String username;
    private String password;

    public static Admin getInstance(){
        return instance;
    }

    public Admin() {
    }

    public Admin(String username, String password) {
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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {

    }

}
