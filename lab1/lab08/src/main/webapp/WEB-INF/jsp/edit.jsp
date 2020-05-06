<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение пользователя</title>
</head>
<body>
    <h1>Изменение пользователя</h1>
    <form id="form-edit" action="/users/edit/${user.id}" method="POST">
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
                    <button>Изменить</button>
                    <br>
                    <a href="/users">К списку пользователей</a>
                </th>
            </tfoot>
        </table>
    </form>
</body>
</html>