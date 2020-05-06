<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
    <h1>Добавление пользователя</h1>
    <form id="form-create" action="/users/create" method="POST">
        <table>
            <tr>
                <td><label>Имя:</label></td>
                <td><input name="name" type="text" value="${user.name}"/></td>
            </tr>
            <tr>
                <td><label>Должность:</label></td>
                <td><input name="position" type="text" value="${user.position}"/></td>
            </tr>
            <tfoot>
                <th colspan="2" style="padding-top:20px">
                    <button>Добавить</button>
                    <br>
                    <a href="/users">К списку пользователей</a>
                </th>
            </tfoot>
        </table>
    </form>
</body>
</html>