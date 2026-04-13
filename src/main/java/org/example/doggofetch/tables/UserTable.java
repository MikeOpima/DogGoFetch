package org.example.doggofetch.tables;

import org.example.doggofetch.dao.UserDAO;
import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.pojo.User;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;

/**
 * UserTable
 * @date April  2, 2026
 * @author Hania
 */

public class UserTable implements UserDAO {
    private static UserTable instance;
    Database db = Database.getInstance();
    ArrayList<User> users = new ArrayList<>();

    public static UserTable getInstance(){
        if (instance == null){
            instance = new UserTable();
        }
        return instance;
    } //get UserTable instance

    @Override
    public ArrayList<User>getAllUsers(){
        String query = "SELECT * FROM " + TABLE_USER;
        users=new ArrayList<>();
        try{
            Statement getUsers = db.getConnection().createStatement();
            ResultSet data = getUsers.executeQuery(query);
            while (data.next()){
                users.add(new User(
                        data.getInt(USER_COLUMN_ID),
                        data.getString(USER_COLUMN_USER_NAME),
                        data.getString(USER_COLUMN_FIRST_NAME),
                        data.getString(USER_COLUMN_LAST_NAME),
                        data.getString(USER_COLUMN_PASSWORD),
                        data.getString(USER_COLUMN_ROLE)
                ));
            }
            return users;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }// end getAllUsers

    @Override
    public User getUser(int id){
        String query = "SELECT * FROM "+ TABLE_USER+
                " WHERE " + USER_COLUMN_ID +" = " + id;
        try{
            Statement getUser= db.getConnection().createStatement();
            ResultSet data = getUser.executeQuery(query);
            if (data.next()){
                return new User(
                        data.getInt(USER_COLUMN_ID),
                        data.getString(USER_COLUMN_USER_NAME),
                        data.getString(USER_COLUMN_FIRST_NAME),
                        data.getString(USER_COLUMN_LAST_NAME),
                        data.getString(USER_COLUMN_PASSWORD),
                        data.getString(USER_COLUMN_ROLE)
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }//end getUsers

    @Override
    public void createUser(User user) {
        String query = "INSERT INTO " + TABLE_USER +
                "(" + USER_COLUMN_USER_NAME + ", " +
                USER_COLUMN_FIRST_NAME + ", " +
                USER_COLUMN_LAST_NAME + ", " +
                USER_COLUMN_PASSWORD + ", " +
                USER_COLUMN_ROLE + ") VALUES ('" +
                user.getUserName() + "', '" +
                user.getFirstName() + "', '" +
                user.getLastName() + "', '" +
                user.getPassword() + "', '" +
                user.getUserRole() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Created User");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //end createUser

    @Override
    public void updateUser(User user) {
        String query = "UPDATE " + TABLE_USER + " SET " +
                USER_COLUMN_USER_NAME + " = '" + user.getUserName() + "', " +
                USER_COLUMN_FIRST_NAME + " = '" + user.getFirstName() + "', " +
                USER_COLUMN_LAST_NAME + " = '" + user.getLastName() + "', " +
                USER_COLUMN_PASSWORD + " = '" + user.getPassword() + "', " +
                USER_COLUMN_ROLE + " = '" + user.getUserRole() + "' " +
                "WHERE " + USER_COLUMN_ID + " = " + user.getId();

        try {
            db.getConnection().createStatement().executeUpdate(query);
            System.out.println("Updated User");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //end updateUser

    @Override
    public void deleteUser(int id) {
        String query = "DELETE FROM " + TABLE_USER +
                " WHERE " + DBConst.USER_COLUMN_ID + " = " + id;

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted User");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end deleteUser
}//end UserTable class