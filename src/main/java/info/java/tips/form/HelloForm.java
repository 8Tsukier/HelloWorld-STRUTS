package info.java.tips.form;

import org.apache.struts.action.ActionForm;

import java.util.LinkedList;
import java.util.List;

public class HelloForm extends ActionForm {
    private String name;
    private String lvl;
//    public static List<User> myList = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public User getUser() {
        return new User(name, lvl);
    }

//    public List<User> getMyList() {
//        return myList;
//    }
}