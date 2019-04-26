package info.java.tips.action;

import java.sql.*;

import info.java.tips.DBStuff.DBOperations;
import info.java.tips.form.HelloForm;
import info.java.tips.form.User;
import info.java.tips.form.UserList;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class HelloAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HelloForm helloForm = (HelloForm) form;
        User user = helloForm.getUser();
        ActionForward fw = mapping.getInputForward();

        if(user!= null && user.getName() != ""){
//            DBOperations dbOperations = new DBOperations();
            try{
                DBOperations.getInstance().insertUser(user);
            } catch (SQLException e){
                e.printStackTrace();
            }
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
