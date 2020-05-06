<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Users List Page</title>
    </head>
    <body>
        <h1>Список пользователей (${userscount})</h1>
        <a href="/Java01-war/userCreate">Создать</a>
        <table>
            <tr>
                <th></th>
                <th>Имя</th>
                <th>Должность</th>
                <th></th>
            </tr>
            <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.position}</td>
                <td><a href="/Java01-war/userEdit?id=${user.id}">Изменить</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
