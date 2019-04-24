<%@ page import="info.java.tips.form.UserList" %>
<%@ page import="info.java.tips.form.HelloForm" %>
<%@ page import="info.java.tips.form.User" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<style>
    #footer{
        position: fixed; /* Фиксированное положение */
        left: 0; bottom: 0; /* Левый нижний угол */
        padding: 10px; /* Поля вокруг текста */
        color: azure; /* Цвет текста */
        width: 100%; /* Ширина слоя */
    }
</style>

<h1>Current user list: </h1>

<%--<%= UserList.getInstance().toString() %>--%>

<%--<table border="1">--%>

<%--    <tr>--%>
<%--        <td>Username</td>--%>
<%--        <td>User Level</td>--%>
<%--    </tr>--%>

<%--    <logic:iterate id="listUsersId" name="listUsers">--%>
<%--        <tr>--%>
<%--            <td><b:write name="listUserId" property="name"/> </td>--%>
<%--            <td><b:write name="listUserId" property="lvl" /> </td>--%>
<%--        </tr>--%>
<%--    </logic:iterate>--%>

<%--</table>--%>


<table border="1">

    <tr>
        <td>Username</td>
        <td>User Level</td>
    </tr>
<% for(int i = 0; i < UserList.getInstance().getList().size(); i++){
        User aa = (User) UserList.getInstance().getList().get(i);
%>
        <tr>
            <td><%= aa.getName()%> </td>
            <td><%= aa.getLvl()%> </td>
        </tr>
<%}%>
</table>

<html:form action="/back">
    <html:submit value="Ok"/>
</html:form>


<div id="footer">
    <footer>
        <p align="left" style="color: black">&copy; Using STRUTS v1.3.10</p>
    </footer>
</div>