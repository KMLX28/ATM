import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AnotherAmountController extends WithdrawController {

    // Variable to hold the specific amount while the user writing it.
    // StringBuilder instead of String, because there will be multiple changes to the amount.
    private StringBuilder anotherAmount = new StringBuilder();
    // to make it draggable one time
    private boolean isDraggable = false;

    @FXML
    private JFXTextField AmountTextField;

    @FXML
    private JFXButton two;

    @FXML
    private JFXButton one;

    @FXML
    private JFXButton five;

    @FXML
    private JFXButton four;

    @FXML
    private JFXButton zero;

    @FXML
    private JFXButton eight;

    @FXML
    private JFXButton seven;

    @FXML
    private JFXButton enterButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton clearButton;

    @FXML
    private JFXButton six;

    @FXML
    private JFXButton nine;

    @FXML
    private JFXButton three;

    @FXML
    private Label WithdrawMenu;

    @FXML
    private ImageView exitIcon;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label insufficientFundsLabel;

    @FXML
    private Label controlBar;

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
    void deleteButtonPressed(ActionEvent event) {

        if (anotherAmount.length() != 0) {
            anotherAmount.deleteCharAt(anotherAmount.length() - 1);
            AmountTextField.setText(String.valueOf(anotherAmount));
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {

        anotherAmount = new StringBuilder();
        AmountTextField.setText("");
    }

    @FXML
    void eightPressed(ActionEvent event) {
        anotherAmount.append(8);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void enterButtonPressed(ActionEvent event) {
        amount = Integer.valueOf(String.valueOf(anotherAmount));
        execute();

    }

    @FXML
    void fivePressed(ActionEvent event) {
        anotherAmount.append(5);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void fourPressed(ActionEvent event) {
        anotherAmount.append(4);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void ninePressed(ActionEvent event) {
        anotherAmount.append(9);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void onePressed(ActionEvent event) {
        anotherAmount.append(1);
        AmountTextField.setText(String.valueOf(anotherAmount));
    }

    @FXML
    void sevenPressed(ActionEvent event) {
        anotherAmount.append(7);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void sixPressed(ActionEvent event) {
        anotherAmount.append(6);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void threePressed(ActionEvent event) {
        anotherAmount.append(3);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void twoPressed(ActionEvent event) {
        anotherAmount.append(2);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void zeroPressed(ActionEvent event) {
        anotherAmount.append(0);
        AmountTextField.setText(String.valueOf(anotherAmount));

    }

    @FXML
    void initialize() {

        // disable delete and enter buttons button if nothing written in the fields.
        BooleanBinding booleanBinding = AmountTextField.textProperty().isEmpty();

        deleteButton.disableProperty().bind(booleanBinding);
        enterButton.disableProperty().bind(booleanBinding);
        clearButton.disableProperty().bind(booleanBinding);


    }
}
