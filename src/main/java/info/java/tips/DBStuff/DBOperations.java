package info.java.tips.DBStuff;

import info.java.tips.form.User;

import java.sql.*;
import java.util.ArrayList;

public class DBOperations {
    private final static String DB_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USERNAME ="sa";
    private final static String DB_PASSWORD = "";
    private static DBOperations instance;

    public ArrayList<DBUser> listDB;

    public static DBOperations getInstance(){
        if (instance == null)
            instance = new DBOperations();

        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Class Connection ERROR");
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
//        DBOperations dbOperations = new DBOperations();
//        Connection connection = dbOperations.getConnection();

        Connection connection = DBOperations.getInstance().getConnection();

        Statement statement = connection.createStatement();
//        String dropSql = "DROP TABLE UsersTable";
//        statement.executeUpdate(dropSql);

        String sql =  "CREATE TABLE IF NOT EXISTS UsersTable " +
                "(id INTEGER auto_increment NOT NULL , " +
                " Username VARCHAR(255), " +
                " Userlevel VARCHAR(255), " +
                " PRIMARY KEY (id))";

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Created table in given database...");

        String name = user.getName();
        String lvl = user.getLvl();

//        sql = "INSERT INTO UsersTable (Username, Userlevel) values (name, lvl)";
        PreparedStatement preparedStatement;
        try {
//            statement.executeUpdate(sql);
            preparedStatement = connection.prepareStatement("INSERT INTO UsersTable (Username, Userlevel) values (?, ?)");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lvl);

            int rc = preparedStatement.executeUpdate();
//            System.out.println("Row Count: "+ rc);
            System.out.println("User \"" + name + "\" was inseted into a DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.close();
    }

    public void removeUser(User user) throws SQLException {
        DBOperations dbOperations = new DBOperations();
        Connection connection = dbOperations.getConnection();

        Statement statement = connection.createStatement();

        String sql =  "";

        String name = user.getName();

//        sql = "DROP FROM UsersTable WHERE (Username, Userlevel) values (name, lvl)";
        PreparedStatement preparedStatement;
        try {
            statement.executeUpdate(sql);
            preparedStatement = connection.prepareStatement("DELETE FROM UsersTable WHERE Username = ? ");

            preparedStatement.setString(1, name);

            int rc = preparedStatement.executeUpdate();
//            System.out.println("Row Count: "+ rc);
            System.out.println("User \"" + name + "\" was removed from a DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }

    public void giveMeUsers() throws SQLException {
        DBOperations dbOperations = new DBOperations();
        Connection connection = dbOperations.getConnection();

        Statement statement = connection.createStatement();

        String sql =  "SELECT * FROM USERSTABLE";
        ResultSet resultSet = statement.executeQuery(sql);

        listDB = new ArrayList<>(); //Resetting the list of users from the DB for the correct output

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString("Username");
            String level = resultSet.getString("Userlevel");
            listDB.add(new DBUser(id, name, level));
        }

    }

    public static void main(String[] args) {
//        DBOperations dbOperations = new DBOperations();
//        dbOperations.getConnection();
        User firstUser = new User("Me", "15");
        User secondUser = new User("Not me", "24");

        try {
//            dbOperations.insertUser(firstUser);
//            dbOperations.insertUser(secondUser);
            DBOperations.getInstance().insertUser(firstUser);
            DBOperations.getInstance().insertUser(secondUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            DBOperations.getInstance().removeUser(firstUser);
//            dbOperations.removeUser(firstUser);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
