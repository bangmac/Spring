<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/06/2020
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/show" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td>
                <form:select path="language">
<%--                    <form:option value="English"/>--%>
<%--                    <form:option value="Vietnamese"/>--%>
<%--                    <form:option value="Japanese"/>--%>
<%--                    <form:option value="Chinese"/>--%>
                    <form:options items = "${languageList}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size</form:label></td>
            <td>Show
                <form:select path="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam filter</form:label></td>
            <td>
                <form:checkbox path="spamFilter" />
                <form:label path="spamFilter" >Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <td><form:label path="color">Color</form:label></td>
            <td>
                <form:checkbox path="color" value="red"/>red
                <form:checkbox path="color" value="blue"/>blue
                <form:checkbox path="color" value="pink"/>pink
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <td>
            <form:radiobutton path = "color" value = "black" label = "Black" />
            <form:radiobutton path = "color" value = "white" label = "White" />
        </td>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>
</body>
</html>