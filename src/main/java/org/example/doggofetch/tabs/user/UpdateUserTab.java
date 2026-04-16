package org.example.doggofetch.tabs.user;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.example.doggofetch.pojo.*;
import org.example.doggofetch.tables.CategoryTable;
import org.example.doggofetch.tables.ProductTable;
import org.example.doggofetch.tables.SupplierTable;
import org.example.doggofetch.tables.UserTable;
import org.example.doggofetch.tabs.product.RemoveProductTab;
import org.example.doggofetch.tabs.product.UpdateProductTab;
import org.example.doggofetch.tabs.supplier.SupplierTab;

import java.util.ArrayList;

/**
 * UpdateUserPane Class
 * @author Hania Charikhi
 * April 13, 2026
 */

public class UpdateUserTab extends GridPane {

    private static  SupplierTab instance;
    public TableView tableView;

    /**
     * Search Feature to Update Product
     *
     * @param arraylist
     * @param id
     * @return
     */
    public int find(ArrayList<?> arraylist, int id) {
        ArrayList<DatabaseItem> searchList = (ArrayList<DatabaseItem>)
                ((ArrayList<?>) arraylist);
        for (int i = 0; i < searchList.size(); i++) {
            if (searchList.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    public UpdateUserTab(User user) {
        TableView tableView = new TableView();

        this.setPadding(new Insets(10,10,10,10));
        this.setVgap(10);
        this.setHgap(10);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        User user1 = user;
        UserTable userTable = UserTable.getInstance();


        // user id
        Text id = new Text("Id: ");
        TextField tfId = new TextField();
        tfId.setText(String.valueOf(user.getId()));
        gridPane.add(id, 0, 0);
        gridPane.add(tfId, 1, 0);

        // username
        Text userName = new Text("UserName: ");
        TextField tfUn = new TextField();
        tfUn.setText(String.valueOf(user.getUserName()));
        gridPane.add(userName, 0, 1);
        gridPane.add(tfUn, 1, 1);

        // user first name
        Text firstName = new Text("FirstName: ");
        TextField tfFName = new TextField();
        tfFName.setText(String.valueOf(user.getFirstName()));
        gridPane.add(firstName, 0, 2);
        gridPane.add(tfFName, 1, 2);

        // user last name
        Text lastName = new Text("LastName: ");
        TextField tfLName = new TextField();
        tfLName.setText(String.valueOf(user.getLastName()));
        gridPane.add(lastName, 0, 3);
        gridPane.add(tfLName, 1, 3);

        // user password name
        Text pass = new Text("Password: ");
        TextField tfPass = new TextField();
        tfPass.setText(String.valueOf(user.getPassword()));
        gridPane.add(pass, 0, 4);
        gridPane.add(tfPass, 1, 4);

        // user userRole
        Text role = new Text("UserRole: ");
        TextField tfURole = new TextField();
        tfURole.setText(String.valueOf(user.getUserRole()));
        gridPane.add(role, 0, 5);
        gridPane.add(tfURole, 1, 5);

        Button updateButton = new Button(" Update User ");
        updateButton.setOnAction((e -> {
            user.setUserName(tfUn.getText());
            user.setUserName(tfFName.getText());
            user.setLastName(tfLName.getText());
            user.setPassword(tfPass.getText());
            user.setUserRole(tfURole.getText());

            userTable.updateUser(user);

            RemoveUserTab.getInstance().refreshTable();

        }));
        this.add(updateButton, 1, 6);
    } // end UpdateProductPan


} // end updateProductTab class
