package org.example.doggofetch.tabs.user;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.User;
import org.example.doggofetch.tables.UserTable;

/**
 * AddUserTab
 * @author hania
 * @date 13apr26
 * add in user tab feature
 * @version 1.0
 */

public class AddUserTab extends Tab {
    private static AddUserTab instance;

    public AddUserTab(){
        this.setText("Add User");

        Text welcome = new Text("Welcome to add user");
        Text confirmMessage = new Text("User Added Successfully");

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        //get table instances
        UserTable userTable = new UserTable();
//        CategoryTable categoryTable = CategoryTable.getInstance();
//        SupplierTable supplierTable = SupplierTable.getInstance();



        Text dbUser = new Text("Enter in USER: ");
        TextField dbUserTf = new TextField();
        root.add(dbUser,0,0);
        root.add(dbUserTf,1,0);
        Text dbPass = new Text("Enter in PASS: ");
        PasswordField dbPassTf = new PasswordField();
        root.add(dbPass,0,1);
        root.add(dbPassTf,1,1);


        Button submitButton = new Button(" Add New User ");
        int id = 0;
        submitButton.setOnAction( e->{
            try {
                User user = new User(
                        id, // null value needs to pass to add in entry
                        dbUser.getText(),
                        Integer.parseInt(dbPass.getText()

                        ));
                userTable.createUser(user);

                // add confirmation pane

//                dbUser.clear();
//                dbPass.clear();
//                tfQty.clear();
//                tfLocation.clear();


                root.add(confirmMessage, 1, 7);

                //UserStatsTab.getInstance().generateChart();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        root.add(submitButton, 1, 6);

        this.setContent(root);

    } // end AddUserTab form

    public static AddUserTab getInstance(){
        if(instance == null){
            instance = new AddUserTab();
        }
        return instance;
    } // end create instance call


} // end addItemTab class
