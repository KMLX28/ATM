import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InformationController {

    // *********************************** Variables *******************************

    // to make it draggable one time
    private boolean isDraggable = false;

    // *********************************** GUI Variables *******************************

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView exitIcon;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label userInformationLabel;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label password;

    @FXML
    private Label ID;

    @FXML
    private Label totalBalance;

    @FXML
    private Label controlBar;

    // *********************************** GUI Customization *******************************

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

    @FXML
    void exitClicked(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    void exitEntered(MouseEvent event) {
        exitIcon.setOpacity(1);
        exitIcon.setImage(MainMenuController.redExitIcon);
    }

    @FXML
    void exitExited(MouseEvent event) {
        exitIcon.setOpacity(0.75);
        exitIcon.setImage(MainMenuController.originalExitIcon);
    }

    @FXML
    void backClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/MainMenu.fxml"));
        fxmlLoader.load();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        Main.getMainStage().setScene(Main.getMainScene());
    }

    @FXML
    void backEntered(MouseEvent event) {
        backIcon.setOpacity(1);
        backIcon.setImage(MainMenuController.blueBackIcon);
    }

    @FXML
    void backExit(MouseEvent event) {
        backIcon.setOpacity(0.75);
        backIcon.setImage(MainMenuController.originalBackIcon);
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
        logoutIcon.setImage(MainMenuController.redLogoutIcon);
    }

    @FXML
    void logoutExited(MouseEvent event) {
        logoutIcon.setOpacity(0.55);
        logoutIcon.setImage(MainMenuController.originalLogoutIcon);

    }

    // *********************************** Initialize *******************************

    @FXML
    void initialize() {
        userInformationLabel.setText(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getFirstName() + "'s Information");
        ID.setText(String.valueOf(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getAccountNumber()));
        firstName.setText(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getFirstName());
        lastName.setText(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getLastName());
        password.setText(String.valueOf(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getPin()));
        totalBalance.setText(String.valueOf(MainMenuController.getBankDatabase().getAccount(MainMenuController.getCurrentAccountNumber()).getTotalBalance()));


    }
}


