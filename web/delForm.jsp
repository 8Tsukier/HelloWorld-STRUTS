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

<h1> Removing user form: </h1>
<html:form action="/deletingUser" >
    <p> Enter Username to delete: <html:text property="name" /> (necessary field)</p>
    <html:submit value="Delete"/>

    <hr />
    <html:errors />
</html:form>

<div id="footer">
    <footer>
        <p align="left" style="color: black">&copy; Using STRUTS v1.3.10</p>
    </footer>
</div>