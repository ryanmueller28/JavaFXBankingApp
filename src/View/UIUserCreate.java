package View;

import javafx.geometry.HPos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class UIUserCreate extends GridPane {

    Label firstNameLbl = new Label("First Name");
    Label lastNameLbl = new Label("Last Name");
    Label AddressLbl = new Label("Address");
    Label PhoneNumber = new Label("Phone Number");
    TextField inputFirstName = new TextField();
    TextField inputLastName = new TextField();
    TextField inputAddress = new TextField();
    TextField inputPhoneNumber = new TextField();

    Button submit = new Button("Submit");

    public void createPane(){

    }

    public UIUserCreate(){
        super();
        ColumnConstraints col1, col2, col3, col4, col5;
        col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        col2 = new ColumnConstraints();
        col2.setPercentWidth(20);

        col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        col4 = new ColumnConstraints();
        col4.setPercentWidth(20);

        col5 = new ColumnConstraints();
        col5.setPercentWidth(20);

        getColumnConstraints().addAll(col1, col2, col3, col4, col5);
        add(firstNameLbl, 0, 0, 1, 1);
        setHalignment(firstNameLbl, HPos.CENTER);

        add(inputFirstName, 0, 1,1,1);
        setHalignment(inputFirstName, HPos.CENTER);

        add(lastNameLbl, 1, 0, 1, 1);
        setHalignment(lastNameLbl, HPos.CENTER);

        add(inputLastName, 1, 1, 1, 1);
        setHalignment(inputLastName, HPos.CENTER);

        add(PhoneNumber, 2, 0, 1, 1);
        setHalignment(PhoneNumber, HPos.CENTER);

        add(inputPhoneNumber, 2, 1, 1, 1);
        setHalignment(inputPhoneNumber, HPos.CENTER);

        add(AddressLbl, 3, 0, 1,1);
        setHalignment(AddressLbl, HPos.CENTER);

        add(inputAddress, 3,1,1,1);
        setHalignment(AddressLbl, HPos.CENTER);

        add(submit, 4, 1, 1,1);
        setHalignment(submit, HPos.CENTER);
    }
}
