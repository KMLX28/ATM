import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class LoginController {

    // *********************************** Variables *******************************

    // to make it draggable one time
    private boolean isDraggable = false;

    // *********************************** GUI Variables *******************************

    @FXML
    private JFXPasswordField PIN;

    @FXML
    private JFXTextField numberAccountField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private ImageView invalidLabel1;

    @FXML
    private ImageView invalidLabel2;

    @FXML
    private ImageView exitIcon;

    @FXML
    private Label controlBar;

    @FXML
    private Label forgotPasswordLabel;


    // *********************************** GUI Customization *******************************

    @FXML
    void forgotPasswordLabelClicked(MouseEvent event) {

    }

    @FXML
    void forgotPasswordLabelEntered(MouseEvent event) {
        forgotPasswordLabel.setOpacity(1);
        forgotPasswordLabel.setTextFill(Color.BURLYWOOD);
    }

    @FXML
    void forgotPasswordLabelExited(MouseEvent event) {
        forgotPasswordLabel.setOpacity(0.8);
        forgotPasswordLabel.setTextFill(Color.BLACK);
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

    // *********************************** GUI Actions *******************************

    @FXML
    void loginPressed(ActionEvent event) throws IOException {

        authenticateUser(event);

    }

    @FXML
    void initialize() {
        // hide the invalid Labels.
        invalidLabel1.setVisible(false);
        invalidLabel2.setVisible(false);

        // make sure the input for numberAccountField is numeric only
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null;
        };
        numberAccountField.setTextFormatter(new TextFormatter<>(filter));

        // disable loginButton button if nothing written in the fields.
        BooleanBinding booleanBinding = Bindings.and(
                PIN.textProperty().isEmpty(),
                numberAccountField.textProperty().isEmpty());

        loginButton.disableProperty().bind(booleanBinding);

    }

    // *********************************** Methods *******************************

    private void authenticateUser(ActionEvent event) throws IOException {


        // takes the account number and PIN from the text fields
        int newAccountNumber = Integer.parseInt(numberAccountField.getText());
        int NewPIN = Integer.parseInt(PIN.getText());

        // check whether authentication succeeded
        if (MainMenuController.getBankDatabase().authenticateUser(newAccountNumber, NewPIN)) {
            MainMenuController.setCurrentAccountNumber(newAccountNumber);

            mainMenuScene();
            //((Node) (event.getSource())).getScene().getWindow().hide();

        } else {
            invalidLabel1.setVisible(true);
            invalidLabel2.setVisible(true);
        }

    }

    private void mainMenuScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/MainMenu.fxml"));
        fxmlLoader.load();

        Stage stage = Main.getMainStage();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        stage.setScene(Main.getMainScene());
        stage.setTitle("Main Menu");
        Main.getMainStage().show();

    }

}
