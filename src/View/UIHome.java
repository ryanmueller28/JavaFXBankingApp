package View;

import javafx.geometry.HPos;
import javafx.scene.control.Button;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;


public class UIHome extends GridPane {

    Button addNewUsrBtn = new Button("Add New User");
    Button addAccountBtn = new Button("Add Account to Existing User");
    Button addUsrToAccountBtn = new Button("Add User to Existing Account");
    Button viewCheckingAccountBtn = new Button("View Checking Account for User");
    Button viewSavingsAccountBtn = new Button("View Savings Account for User");
    Button deleteUsrBtn = new Button("Delete User");
    Button deleteAccountBtn = new Button("Delete Account");

    Button changeUsrBtn = new Button("Change User");
    Button logoutBtn = new Button("Log out");
    Button exitBtn = new Button("Exit");

    public UIHome(){
        super();
        setVgap(20);
        ColumnConstraints colUsrInteract, colAccountInteract, colGeneralInteract;

        colUsrInteract = new ColumnConstraints();
        colUsrInteract.setPercentWidth(30);

        colAccountInteract = new ColumnConstraints();
        colAccountInteract.setPercentWidth(30);

        colGeneralInteract = new ColumnConstraints();
        colGeneralInteract.setPercentWidth(30);

        getColumnConstraints().addAll(colUsrInteract, colAccountInteract, colGeneralInteract);

        add(addNewUsrBtn, 0, 0, 1, 1);
        setHalignment(addNewUsrBtn, HPos.LEFT);
        add(addUsrToAccountBtn, 0, 1, 1, 1);
        setHalignment(addUsrToAccountBtn, HPos.LEFT);
        add(deleteUsrBtn, 0, 2, 1, 1);
        setHalignment(deleteUsrBtn, HPos.LEFT);

        add(addAccountBtn, 1, 0, 1, 1);
        setHalignment(addAccountBtn, HPos.LEFT);
        add(viewCheckingAccountBtn, 1, 1, 1, 1);
        setHalignment(viewCheckingAccountBtn, HPos.LEFT);
        add(viewSavingsAccountBtn, 1, 2, 1, 1);
        setHalignment(viewCheckingAccountBtn, HPos.LEFT);
        add(deleteAccountBtn, 1, 3, 1, 1);
        setHalignment(deleteAccountBtn, HPos.LEFT);

        add(changeUsrBtn, 2, 0, 1,1);
        setHalignment(changeUsrBtn, HPos.LEFT);
        add(logoutBtn, 2, 1, 1, 1);
        setHalignment(logoutBtn, HPos.LEFT);
        add(exitBtn, 2, 2, 1, 1);
        setHalignment(exitBtn, HPos.LEFT);




    }


}
