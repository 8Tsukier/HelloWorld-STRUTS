package info.java.tips.action;

import info.java.tips.form.User;
import info.java.tips.form.UserList;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PrintAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = new ArrayList<>();

        userList.addAll(UserList.getInstance().getList());

        request.setAttribute("listUsers", userList);

        return mapping.findForward("success");
    }
}
