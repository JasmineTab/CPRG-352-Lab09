package models;

import java.io.Serializable;

//User object

public class User implements Serializable{
    
    private String email;
    private String active;
    private String fName;
    private String lName;
    private String password;
    private int role;

    public User() {
    }

    public User(String email, String active, String fName, String lName, String password, int role) {
        this.email = email;
        this.active = active;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
    
}
