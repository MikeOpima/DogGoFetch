package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.Category;

import java.util.ArrayList;
/**
 * CategoryDAO
 * 29mar2026
 * katkoe
 */
public interface CategoryDAO {
        public ArrayList<Category> getAllCategory();
        public Category getCategory(int id);
        public void updateCategory(Category category);
        public void deleteCategory(int id);
        public void createCategory(Category category);
    }
