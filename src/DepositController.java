import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DepositController extends Transaction {


    // *********************************** Variables *******************************

    // to make it draggable one time
    private boolean isDraggable = false;

    private StringBuilder initalAmount = new StringBuilder();

    // *********************************** Getters and Setters *******************************


    // *********************************** GUI Variables *******************************

    @FXML
    private JFXButton clearButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton enterButton;

    @FXML
    private JFXTextField AmountTextField;

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label insufficientFundsLabel;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label controlBar;

    // *********************************** GUI Customization *******************************

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


    // *********************************** GUI Actions *******************************

    @FXML
    void deleteButtonPressed(ActionEvent event) {

        if (initalAmount.length() != 0) {
            initalAmount.deleteCharAt(initalAmount.length() - 1);
            AmountTextField.setText(String.valueOf(initalAmount));
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {

        initalAmount = new StringBuilder();
        AmountTextField.setText("");
    }

    @FXML
    void eightPressed(ActionEvent event) {
        initalAmount.append(8);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void enterButtonPressed(ActionEvent event) {
        execute();
    }

    @FXML
    void fivePressed(ActionEvent event) {
        initalAmount.append(5);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void fourPressed(ActionEvent event) {
        initalAmount.append(4);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void ninePressed(ActionEvent event) {
        initalAmount.append(9);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void onePressed(ActionEvent event) {
        initalAmount.append(1);
        AmountTextField.setText(String.valueOf(initalAmount));
    }

    @FXML
    void sevenPressed(ActionEvent event) {
        initalAmount.append(7);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void sixPressed(ActionEvent event) {
        initalAmount.append(6);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void threePressed(ActionEvent event) {
        initalAmount.append(3);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void twoPressed(ActionEvent event) {
        initalAmount.append(2);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    @FXML
    void zeroPressed(ActionEvent event) {
        initalAmount.append(0);
        AmountTextField.setText(String.valueOf(initalAmount));

    }

    // *********************************** Initialize *******************************

    @FXML
    void initialize() {

        // disable delete and enter buttons button if nothing written in the fields.
        BooleanBinding booleanBinding = AmountTextField.textProperty().isEmpty();

        deleteButton.disableProperty().bind(booleanBinding);
        enterButton.disableProperty().bind(booleanBinding);
        clearButton.disableProperty().bind(booleanBinding);

    }


    // *********************************** Methods *******************************

    @Override
    public void showAfterTransactionScene() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/AfterTransaction.fxml"));
            fxmlLoader.load();
            Scene scene = new Scene(fxmlLoader.getRoot());
            Stage stage = Main.getMainStage();
            stage.setScene(scene);
            stage.setTitle("After Transaction");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute() {

        int amount = Integer.parseInt(initalAmount.toString());

        MainMenuController.getBankDatabase().credit(getCurrentAccountNumber(), amount);
        MainMenuController.getBankDatabase().saveDatabase(getBankDatabase().getAccount(getCurrentAccountNumber()));
        showAfterTransactionScene();
    }
}
