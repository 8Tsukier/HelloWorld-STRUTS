package info.java.tips.form;

import org.apache.struts.action.ActionForm;

public class DeleteUserForm extends ActionForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
