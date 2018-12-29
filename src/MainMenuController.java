import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {


    // *********************************** Variables *******************************

    private static int currentAccountNumber = 0;
    private static BankDatabase bankDatabase = new BankDatabase();

    // to make it draggable one time
    private boolean isDraggable = false;

    static Image redExitIcon = new Image("resources/RedExit.png");
    static Image originalExitIcon = new Image("resources/exit.png");
    static Image originalBackIcon = new Image("resources/originalback.png");
    static Image blueBackIcon = new Image("resources/blueback.png");
    static Image originalLogoutIcon = new Image("resources/logout.png");
    static Image redLogoutIcon = new Image("resources/redlogout.png");

    // *********************************** Getters and Setters *******************************


    static int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    static void setCurrentAccountNumber(int currentAccountNumber) {
        MainMenuController.currentAccountNumber = currentAccountNumber;
    }

    public static BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    // *********************************** GUI Variables *******************************


    @FXML
    private Label welcomeLabel;

    @FXML
    private ImageView exitIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label controlBar;

    // *********************************** GUI Customization *******************************

    @FXML
    void exitClicked() {
        bankDatabase.saveDatabase(bankDatabase.getAccount(MainMenuController.getCurrentAccountNumber()));
        System.exit(1);

    }

    @FXML
    void exitEntered() {
        exitIcon.setImage(MainMenuController.redExitIcon);
    }


    @FXML
    void exitExited() {
        exitIcon.setImage(MainMenuController.originalExitIcon);
    }


    @FXML
    void logoutClicked(MouseEvent event) throws IOException {

        MainMenuController.setCurrentAccountNumber(0);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Login.fxml"));
        fxmlLoader.load();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        Main.getMainStage().setScene(Main.getMainScene());

    }

    @FXML
    void logoutEntered(MouseEvent event) {
        logoutIcon.setOpacity(1);
        logoutIcon.setImage(redLogoutIcon);
    }

    @FXML
    void logoutExited(MouseEvent event) {
        logoutIcon.setOpacity(0.55);
        logoutIcon.setImage(originalLogoutIcon);

    }

    @FXML
    void controlBarClicked(MouseEvent event) {

        if (!isDraggable) Main.getMainScene().setMoveControl(controlBar);

    }


    @FXML
    void controlBarEntered(MouseEvent event) {
        controlBar.setOpacity(1);
        if (!isDraggable) Main.getMainScene().setMoveControl(controlBar);
        isDraggable = true;

    }



    @FXML
    void controlBarExited(MouseEvent event) {
        controlBar.setOpacity(0.85);
    }


    // *********************************** GUI Actions *******************************
    @FXML
    void transferButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Transfer.fxml"));
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        Stage stage = Main.getMainStage();
        stage.setScene(scene);
        stage.setTitle("Transfer Menu");
        stage.show();

    }

    @FXML
    void depositFundsButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Deposit.fxml"));
        fxmlLoader.load();
        Stage stage = Main.getMainStage();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
        stage.setTitle("Deposit Menu");
        stage.show();

    }


    @FXML
    void informationButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Information.fxml"));
        fxmlLoader.load();
        Stage stage = Main.getMainStage();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        stage.setScene(Main.getMainScene());
        stage.setTitle("Information");
        stage.show();


    }

    @FXML
    void withdrawCashButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Withdraw.fxml"));
        fxmlLoader.load();
        Stage stage = Main.getMainStage();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        stage.setScene(Main.getMainScene());
        stage.setTitle("Withdrawal Menu");
        stage.show();
    }


    // *********************************** Initialize *******************************


    @FXML
    void initialize() {

        welcomeLabel.setText("Welcome Back, " + getBankDatabase().getAccount(currentAccountNumber).getFirstName());

    }

}
