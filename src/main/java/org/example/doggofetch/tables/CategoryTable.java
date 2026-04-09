package org.example.doggofetch.tables;

import org.example.doggofetch.database.Database;
import org.example.doggofetch.dao.CategoryDAO;
import org.example.doggofetch.pojo.Category;

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
        String query = "SELECT * FROM " + TABLE_CATEGORY;
        categories = new ArrayList<>();
        try{

            //TODO RUN QUERY
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);

            while (resultSet.next()){
                categories.add(new Category(
                        resultSet.getInt(CATEGORY_COLUMN_ID),
                        resultSet.getString(CATEGORY_COLUMN_NAME)
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    } // end getALLCategory



    public Category getCategory(int id){
        String query = "SELECT * FROM " + TABLE_CATEGORY + " WHERE " + CATEGORY_COLUMN_ID + " = " + id;
        try {
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);
            if(resultSet.next()){
                Category coin = new Category(
                        resultSet.getInt(CATEGORY_COLUMN_ID),
                        resultSet.getString(CATEGORY_COLUMN_NAME)
                );
                return coin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    } // end getCategory

    public static CategoryTable getInstance(){
        if(instance == null){
            instance = new CategoryTable();
        }
        return instance;
    } // get CategoryTable instance


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

} // end Category Table Class
