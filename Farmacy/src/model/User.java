package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class User implements IUser {

    private Integer id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }
}
