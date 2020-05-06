<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Изменение пользователя ${user.id}</h1>
        <form action="userEdit" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <table>
                <tr> 
                    <td>Имя</td>
                    <td><input required type="text" name="name" value="${user.name}"></td>
                </tr>
                <tr> 
                    <td>Должность</td>
                    <td><input required type="text" name="position" value="${user.position}"></td>
                </tr>
                <tr> 
                    <td colspan="2"><input type="submit" value="Изменить"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
