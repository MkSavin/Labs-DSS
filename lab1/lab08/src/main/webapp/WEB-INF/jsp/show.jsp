<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Просмотр пользователей</title>
</head>
<body>
    <h1>Просмотр пользователей</h1>
    <table>
        <tr>
            <td><label>Имя:</label></td>
            <td><c:out value="${user.name}" /></td>
        </tr>
        <tr>
            <td><label>Должность:</label></td>
            <td><c:out value="${user.position}" /></td>
        </tr>
        <tfoot>
            <th colspan="2" style="padding-top:20px">
                <form id="form-delete" action="/users/delete/${user.id}" method="GET">
                    <button>Удалить</button>
                </form>
                <br>
                <a href="/users">К списку пользователей</a>
            </th>
        </tfoot>
    </table>
</body>
</html>