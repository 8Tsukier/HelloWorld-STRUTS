<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<h1> Sorry. Don`t know who you are...</h1>

<html:form action="/back">
    <html:submit value="Go back"/>
</html:form>

<tiles:insert template="WEB-INF/lib/template/common-layout.jsp">
    <tiles:put name="footer" value="/WEB-INF/lib/template/footer.jsp"/>
</tiles:insert>