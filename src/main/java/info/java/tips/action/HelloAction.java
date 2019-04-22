package info.java.tips.action;

import info.java.tips.form.HelloForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HelloForm helloForm = (HelloForm) form;
        ActionForward fw = mapping.getInputForward();

        if(helloForm!= null && helloForm.getName().equalsIgnoreCase("Illia")){
            fw = mapping.findForward("success");
        } else {
            fw = mapping.findForward("failure");
        }

        return fw;
    }
}
