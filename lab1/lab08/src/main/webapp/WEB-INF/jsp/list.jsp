<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
    <h1>Список пользователей</h1>
    <br>
    <a href="/users/create">Добавить пользователя</a>
    <br>
    <table>
        <thead>
            <th>#</th>
            <th>ФИО</th>
            <th>Должность</th>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.position}"/></td>
                <td>
                    <a href="/users/${user.id}">Просмотр</a> |
                    <a href="/users/delete/${user.id}">Удалить</a> |
                    <a href="/users/edit/${user.id}">Изменить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>