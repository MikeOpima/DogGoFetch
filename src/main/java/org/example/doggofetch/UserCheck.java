package org.example.doggofetch;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.doggofetch.tables.UserTable;

/**
 * User Check class
 * check for user login
 * @author katkoe
 * @version v1.0
 */

public class UserCheck extends BorderPane {
    private static UserCheck instance;

    private String username;
    private String password;
    private String role;

    private static boolean userLoggedIn = false;

    public UserCheck(){

        // user pane check
        BorderPane userCheckPane = new BorderPane();

        UserTable userTable = UserTable.getInstance();

        if(!userLoggedIn){
            this.setCenter(userCheckPane);
            System.out.println("no user detected");

        VBox userVb = new VBox();
        Text userInstructions = new Text("Please Sign-in \n \n");
        Text userUser = new Text("Enter in USER: ");
        TextField userUserTf = new TextField();
        Text userPass = new Text("Enter in PASS: ");
        PasswordField userPassTf = new PasswordField();
        Button userBtn = new Button(" TEST CLICK TO LOGIN ");
        userVb.getChildren().addAll(
                userInstructions, userUser, userUserTf,
                userPass, userPassTf, userBtn);
        userBtn.setOnMouseClicked( e->{
            try{
                // add user
                System.out.println("User Log-in Okay");
                UserCheck.setUserLoggedIn(true);
                Text userMessage = new Text(" ");

                if (userUserTf.equals(userUserTf) && userPassTf.equals(userPassTf)) {
                    //TODO CheckUser method to User Table

                    userMessage.setText("Login Compare Successful!");
                } else {
                   userMessage.setText("Login failed. Please check your credentials.");
                }

                this.setBottom(userMessage);

                this.setCenter(new IndexPane());
            }catch (Exception ex){
                ex.printStackTrace();
                Text userMessage = new Text("Log-in Error try again");
                this.setBottom(userMessage);
            }


        }); /// end user check action

        userCheckPane.setCenter(userVb);
        // end configCheck pane form

        } else {
            setUserLoggedIn(true);
            this.setCenter(new IndexPane());
            System.out.println("user logged in");
        }


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public static void setUserLoggedIn(boolean userLoggedIn) {
        UserCheck.userLoggedIn = userLoggedIn;
    }

    public static UserCheck getInstance(){
        if(instance == null){
            instance = new UserCheck();
        }
        return instance;
    }


}
