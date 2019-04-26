<%@ page import="info.java.tips.form.UserList" %>
<%@ page import="info.java.tips.form.HelloForm" %>
<%@ page import="info.java.tips.form.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="info.java.tips.DBStuff.DBOperations" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<%--<style>--%>
<%--    #footer{--%>
<%--        position: fixed; /* Фиксированное положение */--%>
<%--        left: 0; bottom: 0; /* Левый нижний угол */--%>
<%--        padding: 10px; /* Поля вокруг текста */--%>
<%--        color: azure; /* Цвет текста */--%>
<%--        width: 100%; /* Ширина слоя */--%>
<%--    }--%>
<%--</style>--%>

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

<h4>Users during this session: </h4>

<%
    if(UserList.getInstance().getList().size()==0){
%>
    <h3>No data for now...</h3>
<%}else {%>

<table border="1">

    <tr>
        <td>Username</td>
        <td>User Level</td>
    </tr>
<%
    for(int i = 0; i < UserList.getInstance().getList().size(); i++){
        User aa = (User) UserList.getInstance().getList().get(i);
%>
        <tr>
            <td><%= aa.getName()%> </td>
            <td><%= aa.getLvl()%> </td>
        </tr>
<%}%>
</table>
<%}%>
<h4>All users from database: </h4>

<table border="1">

    <tr>
        <td>User-Id</td>
        <td>Username</td>
        <td>User Level</td>
    </tr>

    <%
        DBOperations.getInstance().giveMeUsers();
        for(int i = 0; i < DBOperations.getInstance().listDB.size(); i++){

    %>

    <tr>
        <td><%= DBOperations.getInstance().listDB.get(i).getId() %></td>
        <td><%= DBOperations.getInstance().listDB.get(i).getName() %></td>
        <td><%= DBOperations.getInstance().listDB.get(i).getLevel() %></td>
        <%}%>
    </tr>

</table>
<p style=" padding-top: 5px"></p><%--Just to separate button from the table--%>
<html:form action="/back">
    <html:submit value="Ok"/>
</html:form>

<tiles:insert template="WEB-INF/lib/template/common-layout.jsp">
    <tiles:put name="footer" value="/WEB-INF/lib/template/footer.jsp"/>
</tiles:insert>

<%--<div id="footer">--%>
<%--    <footer>--%>
<%--        <p align="left" style="color: black">&copy; Using STRUTS v1.3.10</p>--%>
<%--    </footer>--%>
<%--</div>--%>