package info.java.tips.form;

import org.apache.struts.action.ActionForm;

import java.util.LinkedList;
import java.util.List;

public class UserList extends ActionForm {
    private static UserList instance;
    public List<User> list = new LinkedList<>();

    public static UserList getInstance(){
        if (instance == null)
            instance = new UserList();
        return instance;
    }

    public List getList(){
        return list;
    }

    public void addUser(User user){
        list.add(user);
    }

    public void deleteUser(User user) {
        list.remove(user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(User hf: list)
            sb.append(("User: \"" + hf.getName()) + "\", level - " + hf.getLvl() + " ; \n");

        return sb.toString();
    }
}
