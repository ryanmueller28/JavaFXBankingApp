package View;


import Controller.Controller;
import Model.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application implements AppView {
    // Dark Mode css theme
    private final String urlDarkTheme = getClass().getResource("modena_dark.css").toExternalForm();

    private MenuBar mnuBar;

    private Controller controller;

    private Stage primaryStage;

    Scene primaryScene;

    Scene createUserScene;

    private UIUserCreate createUserPane;

    private UIHome uiHome;

    private UISQLLogin uisqlLogin;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;

        configureMenus();

        uiHome = new UIHome();

        primaryScene = new Scene(new VBox(), 1280, 720);
        ((VBox) primaryScene.getRoot()).getChildren().addAll(mnuBar, uiHome);

        Image appIcon = new Image("https://st.depositphotos.com/1732591/1280/v/600/depositphotos_12800548-stock-illustration-money-bag-with-dollar-sign.jpg");

        // This makes it so there's a close prompt on pressing the application's X button
        primaryStage.setOnCloseRequest(e -> confirmExit());
        primaryStage.getIcons().add(appIcon);
        primaryStage.setScene(primaryScene);

        primaryStage.setTitle("Banking App");

        uisqlLogin = new UISQLLogin();

        Stage loginStage = new Stage();

        uisqlLogin.startPopup(loginStage);

        controller = new Controller(this);

        /**
         * This bit of code checks if the login button is pressed
         */
        uisqlLogin.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                /**
                 * TO DO:
                 * Check for SQL Login first, then do this
                 */

                primaryStage.show();
                loginStage.hide();
            }
        });

        /*scene.setOnKeyPressed(controller);*/
        loginStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void DepositIntoAccount(double Amount) {

    }

    @Override
    public void WithdrawFromAccount(double Amount) {

    }

    @Override
    public void CreateNewCustomer() {

    }

    @Override
    public void AddCustomerToAccount(Customer customer, Account account) {

    }

    @Override
    public void AddAccountToCustomer(Customer customer, Account account) {

    }

    @Override
    public void DisplayInterestCalculated() {

    }

    /**
     * Confirm that the user wants to quit the application
     * @return True if player wants to quit, false if not
     */
    @Override
    public boolean confirmExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit the application?");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }

    /**
     * Create the menu bar, menus, and items
     */
    private void configureMenus(){
        Menu mnuApplication, mnuHelp, mnuOptions, mnuChangeTheme;
        MenuItem mtmNewUser, mtmSearchUser, mtmExit, mtmNewAccount, mtmAbout, mtmLightTheme, mtmDarkTheme, mtmBack;

        // The full application, main menu, add and search users...
        mnuApplication = new Menu("_File");
        mtmNewUser = new MenuItem("_New User");
        mtmNewUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createUserPane = new UIUserCreate();
                createUserScene = new Scene(new VBox(), 1280, 720);
                ((VBox) createUserScene.getRoot()).getChildren().addAll(mnuBar, createUserPane);
                primaryStage.setTitle("Banking App - Create New User");
                primaryStage.setScene(createUserScene);
            }
        });
        mtmSearchUser = new MenuItem("_Search User");
        mtmSearchUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // controller.SearchUser
            }
        });
        mtmNewAccount = new MenuItem("_New Account");
        mtmNewAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // controller.NewAccount
            }
        });

        mtmBack = new MenuItem("_Back to home");
        mtmBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (primaryStage.getScene() != primaryScene){
                    try {
                        start(primaryStage);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Already at home");
                    alert.setContentText("You're at the main screen!");
                    Optional<ButtonType> result = alert.showAndWait();
                }
            }
        });

        mtmExit = new MenuItem("E_xit");
        mtmExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.shutDown();
            }
        });

        // Add all items in first menu to menu bar
        mnuApplication.getItems().addAll(mtmNewUser, mtmNewAccount, mtmSearchUser, new SeparatorMenuItem(), mtmBack, new SeparatorMenuItem(), mtmExit);

        // Create the menu help bar
        mnuHelp = new Menu("_Help");
        mtmAbout = new MenuItem("_About");
        mtmAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // controller.displayAbout
            }
        });

        // Create menu options.
        mnuOptions = new Menu("_Options");
        mnuChangeTheme = new Menu("_Change App Theme");
        // On action
        mtmLightTheme = new MenuItem("_Light Theme");
        mtmLightTheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setLightTheme();
            }
        });
        //On Action
        mtmDarkTheme = new MenuItem("_Dark Theme");
        mtmDarkTheme.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setDarkTheme();
            }
        });

        mnuChangeTheme.getItems().addAll(mtmLightTheme, mtmDarkTheme);

        mnuOptions.getItems().addAll(mnuChangeTheme);

        mnuHelp.getItems().addAll(mtmAbout);

        mnuBar = new MenuBar(mnuApplication, mnuOptions, mnuHelp);
    }

    public void setLightTheme(){
        primaryScene.getStylesheets().remove(urlDarkTheme);
        if (createUserScene != null) {
            createUserScene.getStylesheets().remove(urlDarkTheme);
        }
    }

    public void setDarkTheme() {
        primaryScene.getStylesheets().add(urlDarkTheme);
        if (createUserScene != null) {
            createUserScene.getStylesheets().add(urlDarkTheme);
        }
    }

}
