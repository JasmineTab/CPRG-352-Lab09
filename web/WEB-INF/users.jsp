<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="./styles/style.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>

        <!--Management-->
        <div class="manageSect">
            <h2>Manage Users</h2>
            <table class="table">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.fName}</td>
                        <td>${user.lName}</td>
                        <td>${user.role.rName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${user.active == false}">
                                    Inactive
                                </c:when>
                                <c:otherwise>
                                    Active
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:url value="/users" var="editURL">
                                <c:param name="action" value="edit"/>
                                <c:param name="emailChosen" value="${user.email}"/>
                            </c:url>
                            <a href="${editURL}">&#9998</a>
                        </td>
                        <td>
                            <c:url value="/users" var="deleteURL">
                                <c:param name="action" value="delete"/>
                                <c:param name="emailChosen" value="${user.email}"/>
                            </c:url>
                            <a href="${deleteURL}">&#10006</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!--Adding-->
        <c:if test="${user == null}">
            <div class="addSect addAndEdit">
                <h2>Add User</h2>
                <form action="" method="post">
                    <div class="information">
                        <input type="hidden" name="action" value="add">
                        <input type="email" name="emailAdd" placeholder="Email" value="" required>
                        <input type="checkbox" name="activeAdd"> Active 
                        <br><br>
                        <input type="text" name="fNameAdd" placeholder="First Name" value="" required>
                        <input type="text" name="lNameAdd" placeholder="Last Name" value="" required>
                        <br><br>
                        <input type="password" name="passAdd" placeholder="Password" value="" required="">
                        <select name="roleAdd">
                            <c:forEach var="role" items="${roles}">
                                <option value="${role.rID}">${role.rName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br><br>
                    <input type="submit" value="Add User" class="addButt">
                </form>
            </div>
        </c:if>

        <!--Edit-->
        <c:if test="${user != null}">
            <div class="editSect addAndEdit">
                <h2>Edit User</h2>
                <form action="" method="post">
                    <div class="information">
                        <input type="email" name="emailEdit" placeholder="Email" value="${user.email}" disabled required>
                        <label for="activeEdit">Active</label>
                        <c:choose>
                            <c:when test="${user.active == true}">
                                <input id="activeEdit" type="checkbox" name="activeEdit" checked="checked"/>
                            </c:when>
                            <c:otherwise>
                                <input id="activeEdit" type="checkbox" name="activeEdit"/>
                            </c:otherwise>
                        </c:choose>
                        <br><br>
                        <input type="text" name="fNameEdit" placeholder="First Name" value="${user.fName}" required>
                        <input type="text" name="lNameEdit" placeholder="Last Name" value="${user.lName}" required>
                        <br><br>
                        <input type="password" name="passEdit" placeholder="Password" value="${user.password}" required="">
                        <select name="roleEdit">
                            <c:forEach var="role" items="${roles}">
                                <c:choose>
                                    <c:when test="${role.rID == user.role.rID}">
                                        <option value="${role.rID}" selected>${role.rName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${role.rID}">${role.rName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <br><br>
                    <div class="buttons">
                        <input type="submit" name="action" value="Edit" class="editButt">
                        <input type="submit" name="action" value="Cancel" class="cancelButt">
                    </div>
                </form>
            </div>
        </c:if>

        <p>${message}</p>
    </body>
</html>
