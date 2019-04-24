package info.java.tips.action;

import info.java.tips.form.HelloForm;
import info.java.tips.form.User;
import info.java.tips.form.UserList;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HelloForm helloForm = (HelloForm) form;
        User user = helloForm.getUser();
        ActionForward fw = mapping.getInputForward();

        if(user!= null && user.getName() != ""){
//            HelloForm.myList.add(user);
//            UserList.getInstance().addUser(user);
            UserList.getInstance().list.add(user);
            fw = mapping.findForward("success");
            System.out.println(UserList.getInstance());
        } else {
            fw = mapping.findForward("failure");
        }

        return fw;
    }
}
