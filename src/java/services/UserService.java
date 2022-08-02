package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import models.Role;
import models.User;

public class UserService {
    public User get(String email) throws Exception {
        UserDB noteDB = new UserDB();
        User user = noteDB.get(email);
        return user;
    }
    
    public ArrayList<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        ArrayList<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, boolean active, String fName, String lName, String password, Role role) throws Exception {
        User user = new User(email, active, fName, lName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String fName, String lName, String password, Role role) throws Exception {
        User user = new User(email, active, fName, lName, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
