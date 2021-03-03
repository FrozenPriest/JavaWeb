<%@ page contentType="text/html;charset=UTF-8" errorPage="error_page.jsp" %>


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
    body{
        background-color: ${cookie['color'].value};
    }

</style>
<html>
<head>
    <title>Song library of ${cookie['user'].value}</title>

</head>
<body>
<div>
    <%
        System.out.println("Servlet session: " + session.getId());
        String name = (String) session.getAttribute("user");
        System.out.println("Name: " + name);
        if (name == null || name.trim().equals(""))
            throw new IllegalArgumentException("Name expected");
    %>
</div>
<div id="header">
    <h1>Get song, ${cookie['user'].value}. You entered ${sessionScope.count} times. </h1>
    <h1>Last enter: ${sessionScope.lastEnter}</h1>
</div>
<form action="${pageContext.request.contextPath}/getSongDetails" method="GET" class="layout-form">
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
