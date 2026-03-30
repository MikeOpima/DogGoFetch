package org.example.doggofetch.tables;

import org.example.doggofetch.database.Database;
import org.example.doggofetch.dao.CategoryDAO;
import org.example.doggofetch.pojo.Category;

import java.awt.image.DataBuffer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;


public class CategoryTable implements CategoryDAO {
    private static CategoryTable instance;
    Database db = Database.getInstance();
    ArrayList<Category> categories;

    @Override
    public ArrayList<Category> getAllCategory() {
        return null;
    } // end getALLCategory

    public Category getCategory(int id){
        return null;
    } // end getCategory

    public static CategoryTable getInstance(){
        if(instance == null){
            instance = new CategoryTable();
        }
        return instance;
    } // get CategoryTable instance

    @Override
    public void deleteCategory(int id) {
        String query  = "DELETE FROM " + TABLE_CATEGORY + " WHERE " +
                CATEGORY_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Category");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end Delete Category Method

    @Override
    public void createCategory(Category category) {
        String query = "INSERT INTO " + TABLE_CATEGORY +
                "(" + CATEGORY_COLUMN_NAME + ") VALUES ('" +
                category.getName() + "')";
        try{
            db.getConnection().createStatement().execute(query);
            System.out.println("Create Category");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



} // end Category Table Class
