package org.example.doggofetch.pojo;

/**
 * User pojo
 * April 2, 2026
 * Hania
 */

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String userRole;

    public User(int id, String firstName, String lastName, String password, String userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String firstName, String lastName, String password, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUserRole() {return userRole;}

    public void setUserRole(String userRole) {this.userRole = userRole;}
}