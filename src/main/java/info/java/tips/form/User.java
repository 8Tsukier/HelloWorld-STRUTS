package info.java.tips.form;

public class User{
    private String name;
    private String lvl;

    public User(String name, String lvl) {
        this.name = name;
        this.lvl = lvl;
    }

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

}