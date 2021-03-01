<%--
  Created by IntelliJ IDEA.
  User: boral
  Date: 01.03.2021
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<style>
    .layout-form {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error_page.jsp" %>
<html>
<head>
    <title>Song library</title>

</head>
<body>
<div>
    <% request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("Name expected");
    %>
</div>
<div id="header" class="layout-form">
    <h1>Get song</h1>
</div>
<form action="getSongInfo" method="GET" class="layout-form">
    <table>
        <tr>
            <td><b>Song ID</b></td>
            <td>
                <label>
                    <input type="number" name="id" value="0"/>
                </label>
            </td>
        </tr>

        <tr>
            <td><b>Language</b></td>
            <td>
                <label>
                    <input type="text" name="lang" value="ru"/>
                </label>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="Get song"/></td>
        </tr>
    </table>
</form>

</body>
</html>
