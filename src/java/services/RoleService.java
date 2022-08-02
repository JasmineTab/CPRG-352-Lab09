package services;

import dataaccess.RoleDB;
import java.util.ArrayList;
import java.util.List;
import models.Role;

public class RoleService {

    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
    }
    
    public Role getRole(int id) throws Exception{
        RoleDB rDB = new RoleDB();
        Role role = rDB.getRole(id);
        
        return role;
    }
}
