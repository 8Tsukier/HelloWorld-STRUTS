package info.java.tips.action;

import info.java.tips.DBStuff.DBOperations;
import info.java.tips.form.DeleteUserForm;
import info.java.tips.form.HelloForm;
import info.java.tips.form.User;
import info.java.tips.form.UserList;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DeleteUserForm deleteUserForm = (DeleteUserForm) form;
        ActionForward fw = mapping.getInputForward();
        User userTODelete = new User(deleteUserForm.getName(),"");

        if(deleteUserForm.getName()!= null){
            DBOperations dbOperations = new DBOperations();
            dbOperations.removeUser(userTODelete);

            for(int i = 0; i < UserList.getInstance().getList().size(); i++){
                User a = (User) UserList.getInstance().getList().get(i);
                if(a.getName().equalsIgnoreCase(deleteUserForm.getName()))
                    UserList.getInstance().getList().remove(i);
//                    HelloForm.myList.remove(i);
            }
            fw = mapping.findForward("success");
            System.out.println(UserList.getInstance());
        } else {
            fw = mapping.findForward("failure");
        }

        return fw;
    }
}
