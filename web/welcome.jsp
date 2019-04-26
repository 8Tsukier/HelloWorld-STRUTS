<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<%--<style>--%>
<%--    #footer{--%>
<%--        position: fixed; /* Фиксированное положение */--%>
<%--        left: 0; bottom: 0; /* Левый нижний угол */--%>
<%--        padding: 10px; /* Поля вокруг текста */--%>
<%--        color: azure; /* Цвет текста */--%>
<%--        width: 100%; /* Ширина слоя */--%>
<%--    }--%>
<%--</style>--%>

<h1>User <b:write name="helloForm" property="name" /> welcome to struts!</h1>

<html:form action="/back">
    <html:submit value="Ok"/>
</html:form>

<%--<div id="footer">--%>
<%--    <footer>--%>
<%--        <p align="left" style="color: black">&copy; Using STRUTS v1.3.10</p>--%>
<%--    </footer>--%>

    <tiles:insert template="WEB-INF/lib/template/common-layout.jsp">
        <tiles:put name="footer" value="/WEB-INF/lib/template/footer.jsp"/>
    </tiles:insert>
</div>