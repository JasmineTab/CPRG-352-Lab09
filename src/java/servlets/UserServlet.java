package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        RoleService rs = new RoleService();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        try {

            ArrayList<User> users = us.getAll();
            request.setAttribute("users", users);

            ArrayList<Role> roles = rs.getAll();
            request.setAttribute("roles", roles);

            if (action != null) {

                if (action.equals("delete")) {
                    String email = request.getParameter("emailChosen");

                    us.delete(email);

                    users = us.getAll();
                    request.setAttribute("users", users);

                    response.sendRedirect("users");
                    session.setAttribute("message", null);
                    return;

                } else if (action.equals("edit")) {
                    String email = request.getParameter("emailChosen");

                    User user = us.get(email);
                    request.setAttribute("user", user);
                }

            }
        } catch (Exception e) {
//            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);

            System.out.println("There was an error: " + e);
            request.setAttribute("message", e);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        session.setAttribute("message", null);

        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        UserService us = new UserService();
        RoleService rs = new RoleService();

        String action = request.getParameter("action");

        request.setAttribute("action", action);
        System.out.println(action + " line 84");

        try {

            if (action != null) {
                System.out.print(action);
                switch (action.toLowerCase()) {
                    case "add":

                        boolean active = false;

                        if (request.getParameter("activeAdd") != null) {
                            active = true;
                        }

                        String email = request.getParameter("emailAdd");
                        String fName = request.getParameter("fNameAdd");
                        String lName = request.getParameter("lNameAdd");
                        String password = request.getParameter("passAdd");
                        Role role = rs.getRole(Integer.parseInt(request.getParameter("roleAdd")));

                        System.out.println("here");
                        
                        us.insert(email, active, fName, lName, password, role);

                        System.out.println("no here");

                        break;

                    case "edit":
                        
                        active = false;

                        if (request.getParameter("activeEdit") != null) {
                            active = true;
                        }

                        email = request.getParameter("emailChosen");
                        fName = request.getParameter("fNameEdit");
                        lName = request.getParameter("lNameEdit");
                        password = request.getParameter("passEdit");
                        role = rs.getRole(Integer.parseInt(request.getParameter("roleEdit")));

                        us.update(email, active, fName, lName, password, role);

                        break;

                    case "cancel":

                        response.sendRedirect("users");
                        break;

                }
            }

        } catch (Exception e) {

            session.setAttribute("message", "There was an error: " + e);
        }

        response.sendRedirect("users");
        return;

    }
}
