import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondTransferController extends TransferController {

    private StringBuilder inputAccountNumber = new StringBuilder();
    static int amount;
    @FXML
    private JFXTextField AmountTextField;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label invalidNumberAccountLabel;

    @FXML
    private ImageView backIcon;

    @FXML
    private JFXRadioButton localBankButton;

    @FXML
    private JFXRadioButton thisBankButton;

    @FXML
    private ToggleGroup group;

    @FXML
    private JFXRadioButton internationalBankButton;

    // *********************************** GUI Actions *******************************

    @FXML
    void deleteButtonPressed(ActionEvent event) {

        if (inputAccountNumber.length() != 0) {
            inputAccountNumber.deleteCharAt(inputAccountNumber.length() - 1);
            AmountTextField.setText(String.valueOf(inputAccountNumber));
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {

        inputAccountNumber = new StringBuilder();
        AmountTextField.setText("");
    }

    @FXML
    void eightPressed(ActionEvent event) {
        inputAccountNumber.append(8);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void enterButtonPressed(ActionEvent event) throws IOException {
        execute();
    }

    @FXML
    void fivePressed(ActionEvent event) {
        inputAccountNumber.append(5);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void fourPressed(ActionEvent event) {
        inputAccountNumber.append(4);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void ninePressed(ActionEvent event) {
        inputAccountNumber.append(9);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void onePressed(ActionEvent event) {
        inputAccountNumber.append(1);
        AmountTextField.setText(String.valueOf(inputAccountNumber));
    }

    @FXML
    void sevenPressed(ActionEvent event) {
        inputAccountNumber.append(7);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void sixPressed(ActionEvent event) {
        inputAccountNumber.append(6);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void threePressed(ActionEvent event) {
        inputAccountNumber.append(3);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void twoPressed(ActionEvent event) {
        inputAccountNumber.append(2);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void zeroPressed(ActionEvent event) {
        inputAccountNumber.append(0);
        AmountTextField.setText(String.valueOf(inputAccountNumber));

    }

    @FXML
    void initialize() {

//        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
//
//            if (group.getSelectedToggle() != null) {
//
//
//
//            }
//        });
    }


    @Override
    public void execute() throws IOException {

        amount = Integer.parseInt(String.valueOf(inputAccountNumber));

        if (amount <= MainMenuController.getBankDatabase().getTotalBalance(getCurrentAccountNumber())) {

            destinationAccount.credit(amount);
            MainMenuController.getBankDatabase().debit(MainMenuController.getCurrentAccountNumber(), amount);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Transfer3.fxml"));
            fxmlLoader.load();
            Scene scene = new Scene(fxmlLoader.getRoot());
            Stage stage = Main.getMainStage();
            stage.setScene(scene);
            stage.setTitle("Enter Amount");
            stage.show();

        } else {

            invalidNumberAccountLabel.setVisible(true);
            errorIcon.setVisible(true);

        }
    }


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
}
