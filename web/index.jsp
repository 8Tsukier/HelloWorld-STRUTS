<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:form action="/hello" >
  <html:text property="name" />
  <html:submit />

  <hr />
  <html:errors />
</html:form>