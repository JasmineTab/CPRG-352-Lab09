<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link type="text/css" rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <!--Adding-->
        <div class="addSect">
            <h2>Add User</h2>
            <form action="user" method="post">
                <input type="email" name="emailAdd" placeholder="Email" value="${emailAdd}">
                <br><br>
                <input type="radio" name="isActive" value="true"> Active 
                <br>
                <input type="radio" name="isActive" value="false"> Inactive 
                <br><br>
                <input type="text" name="fNameAdd" placeholder="First Name" value="${fNameAdd}">
                <br><br>
                <input type="text" name="lNameAdd" placeholder="Last Name" value="${lNameAdd}">
                <br><br>
                <input type="password" name="passAdd" placeholder="Password" value="${passAdd}">
                <br><br>
                <select name="roleAdd">
                    <option>Role played</option>
                    <c:forEach var="role" items="${roles}">
                        <option ${roleAdd == "${role.rName}"?"selected":""} value="${role.rName}">${role.rName}</option>
                    </c:forEach>
                </select>
                <br><br>
                <input type="submit" value="Add User">
                <input type="hidden" value="action" value="add">
            </form>
        </div>

        <!--Management-->
        <div class="manageSect">
            <h2>Manage Users</h2>
            <<table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.fName}</td>
                        <td>${user.lName}</td>
                        <td>${user.role}</td>
                        <td><a href="user?action=edit&amp;email=${user.email}">&#9998</a></td>
                        <td><a href="user?action=delete&amp;email=${user.email}">&#10006</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
                
        <!--Edit-->
        <div class="editSect">
            <h2>Edit User</h2>
            <form action="user" method="post">
                <input type="email" name="emailEdit" placeholder="Email" value="${emailEdit}">
                <br><br>
                <input type="radio" name="activeEdit" value="true"> Active 
                <br>
                <input type="radio" name="activeEdit" value="false"> Inactive 
                <br><br>
                <input type="text" name="fNameEdit" placeholder="First Name" value="${fNameEdit}">
                <br><br>
                <input type="text" name="lNameEdit" placeholder="Last Name" value="${lNameEdit}">
                <br><br>
                <select name="roleEdit">
                    <option>Role played</option>
                    <c:forEach var="role" items="${roles}">
                        <option ${roleEdit == "${role.rName}"?"selected":""} value="${role.rName}">${role.rName}</option>
                    </c:forEach>
                </select>
                <br><br>
                <input type="submit" value="Save User">
                <input type="hidden" value="action" value="edit">
            </form>
        </div>
    </body>
</html>
