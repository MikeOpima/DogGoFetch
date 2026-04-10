package org.example.doggofetch.tables;

import org.example.doggofetch.database.DBConst;
import org.example.doggofetch.database.Database;
import org.example.doggofetch.dao.CategoryDAO;
import org.example.doggofetch.pojo.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.doggofetch.database.DBConst.*;

/**
 * Category Table Class
 * CRUD and getAll get
 * Mike March 2026
 * Hania - updated getAllCategory() method
 */

public class CategoryTable implements CategoryDAO {
    private static CategoryTable instance;
    Database db = Database.getInstance();
    ArrayList<Category> categories;

    public ArrayList<Category> getAllCategory() {
        categories = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CATEGORY;
        try {
            PreparedStatement getCategories = db.getConnection().prepareStatement(query);
            ResultSet data = getCategories.executeQuery();
            while (data.next()) {
                categories.add(new Category(
                        data.getInt(CATEGORY_COLUMN_ID),
                        data.getString(CATEGORY_COLUMN_NAME)
                ));
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//end getAllCategory

    public Category getCategory(int id){
        String query = "SELECT * FROM " + TABLE_CATEGORY +
                " WHERE " + DBConst.CATEGORY_COLUMN_ID + " = " + id;
        try {
            Statement getCategory = db.getConnection().createStatement();
            ResultSet data = getCategory.executeQuery(query);
            if (data.next()) {
                return new Category(
                        data.getInt(DBConst.CATEGORY_COLUMN_ID),
                        data.getString(CATEGORY_COLUMN_NAME) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } // end getCategory

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


    public void updateCategory(Category category) {
        String query = "UPDATE " + TABLE_CATEGORY + " SET " +
                CATEGORY_COLUMN_NAME + "= " + category.getName() + " " +
                "WHERE " + CATEGORY_COLUMN_ID + " = " + category.getId();
        try {
            Statement updateCategory = db.getConnection().createStatement();
            System.out.println("Category" + category.getName() + "Updated");
            updateCategory.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  // end updateProduct

    public static CategoryTable getInstance(){
        if(instance == null){
            instance = new CategoryTable();
            //get table instances
        }
        return instance;
    } // get CategoryTable instance






} // end Category Table Class