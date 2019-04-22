package info.java.tips.form;

import org.apache.struts.action.ActionForm;

public class HelloForm extends ActionForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
 <welcome-file-list>
        <welcome-file>hello</welcome-file>
    </welcome-file-list>

    <servlet>
        <servlet-name>hello</servlet-name>
        <jsp-file>/hello.jsp</jsp-file>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>welcome</servlet-name>
        <jsp-file>/welcome.jsp</jsp-file>
    </servlet>
    <servlet-mapping>
        <servlet-name>welcome</servlet-name>
        <url-pattern>/welcome</url-pattern>
    </servlet-mapping>
*/
