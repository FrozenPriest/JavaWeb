<style>
    .layout-form {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 class="layout-form"><%= "Song library!" %>
</h1>
<br/>
<form action="${pageContext.request.contextPath}/login" class="layout-form">
    <table>
        <tr>
            <td>Enter your name</td>
            <td>
                <label>
                    <input type="text" name="name"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Enter your color</td>
            <td>
                <label>
                    <input type="color" name="color"/>
                </label>
            </td>
        </tr>
        <tr>
            <th colspan="2" style="align-items: center"><input type="submit" value="Open library"/></th>
        </tr>

    </table>
</form>
</body>
</html>