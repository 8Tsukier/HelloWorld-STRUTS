<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
</head>

<style>
    #footer{
        position: fixed; /* Фиксированное положение */
        left: 0; bottom: 0; /* Левый нижний угол */
        padding: 10px; /* Поля вокруг текста */
        color: azure; /* Цвет текста */
        width: 100%; /* Ширина слоя */
    }
</style>

<h1> Welcome to the first form: </h1>
<p>Select the action: </p>

<p> <html:form action="/addUser" >
    <html:submit value="AddUser"/>
    <hr />
    <html:errors />
</html:form>

<html:form action="/deleting" >
    <html:submit value="DelUser"/>
    <hr />
    <html:errors />
</html:form>

<html:form action="/watchList" >
    <html:submit value="WatchList"/>
    <hr />
    <html:errors />
</html:form>
</p>

<%--<div id="footer">--%>
<%--    <footer>--%>
<%--        <p align="left" style="color: black">&copy; Using STRUTS v1.3.10</p>--%>
<%--    </footer>--%>
<%--</div>--%>

<tiles:insert template="WEB-INF/lib/template/common-layout.jsp">
    <tiles:put name="footer" value="/WEB-INF/lib/template/footer.jsp"/>
</tiles:insert>

</html>