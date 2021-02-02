package View;


import Controller.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Optional;


public class UISQLLogin extends Popup{

    Button loginButton = new Button("Login");
    Button cancelButton = new Button("Cancel");
    GridPane gridPane = new GridPane();
    Label mainLabel = new Label("Login to SQL Database");

    Label jbdcSchemaLabel = new Label("JBDC Schema: ");
    TextField inputJBDCSchema = new TextField();

    Label userNameLabel = new Label("User name: ");
    TextField inputUserName = new TextField();

    Label userPasswordLabel = new Label("Password: ");
    TextField inputPassword = new TextField();

    Popup popup = new Popup();

    Controller controller;

    public Button getLoginButton() { return loginButton; }

    public UISQLLogin(){
        super();

        ColumnConstraints col1, col2, col3;
        col1 = new ColumnConstraints();
        col1.setPercentWidth(33);

        col2 = new ColumnConstraints();
        col2.setPercentWidth(33);

        col3 = new ColumnConstraints();
        col3.setPercentWidth(33);

        gridPane.getColumnConstraints().addAll(col1, col2, col3);

        gridPane.add(jbdcSchemaLabel, 0, 0, 1, 1);
        gridPane.setHalignment(jbdcSchemaLabel, HPos.CENTER);
        gridPane.add(inputJBDCSchema, 0, 1, 1, 1);
        gridPane.setHalignment(inputJBDCSchema, HPos.CENTER);

        gridPane.add(userNameLabel, 1, 0, 1, 1);
        gridPane.setHalignment(userNameLabel, HPos.CENTER);
        gridPane.add(inputUserName, 1, 1, 1, 1);
        gridPane.setHalignment(inputUserName, HPos.CENTER);

        gridPane.add(userPasswordLabel, 2, 0, 1, 1);
        gridPane.setHalignment(userPasswordLabel, HPos.CENTER);
        gridPane.add(inputPassword, 2, 1, 1, 1);
        gridPane.setHalignment(inputPassword, HPos.CENTER);

        gridPane.add(cancelButton, 2, 2, 1, 1);
        gridPane.setHalignment(cancelButton, HPos.LEFT);


        gridPane.add(loginButton, 2, 2, 2, 1);
        gridPane.setHalignment(loginButton, HPos.RIGHT);
    }

    public void startPopup(Stage stage){
        stage.setTitle("Login to Database");

        popup.getContent().add(mainLabel);

        Scene scene = new Scene(gridPane);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (confirmExit()){
                    Platform.exit();
                }
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
/*                SQLBaseHelper sqlBaseHelper = controller.getSqlBaseHelper();
                try {
                    sqlBaseHelper.Login(inputJBDCSchema.getText(), inputUserName.getText(), inputPassword.getText());
                }catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }*/
            }
        });

        stage.setOnCloseRequest(e -> confirmExit());
        stage.setScene(scene);
    }

    public boolean confirmExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit the application?");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }

}
