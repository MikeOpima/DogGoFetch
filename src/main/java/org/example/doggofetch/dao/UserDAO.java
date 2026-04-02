package org.example.doggofetch.dao;

import org.example.doggofetch.pojo.User;

import java.util.ArrayList;

public interface UserDAO {
    public ArrayList<User> getAllUsers();
    public User getUser (int id);
    public void createUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
