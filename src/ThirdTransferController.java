import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ThirdTransferController extends SecondTransferController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label accountNumberLabel;

    @FXML
    private Label amountLabel;


    @FXML
    private JFXButton confirmButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private Label enterAmountLabel;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label invalidNumberAccountLabel;

    @FXML
    private Label controlBar;

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView exitIcon;

    @FXML
    private ImageView logoutIcon;


    @FXML
    void cancelButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/MainMenu.fxml"));
        fxmlLoader.load();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        Main.getMainStage().setScene(Main.getMainScene());

    }

    @FXML
    void confirmButtonPressed(ActionEvent event) {
        MainMenuController.getBankDatabase().saveDatabase(destinationAccount);
        MainMenuController.getBankDatabase().saveDatabase(getBankDatabase().getAccount(getCurrentAccountNumber()));
        showAfterTransactionScene();
    }


    @FXML
    void initialize() {

        fullNameLabel.setText(destinationAccount.toString());
        accountNumberLabel.setText(String.valueOf(destinationAccount.getAccountNumber()));
        amountLabel.setText(String.valueOf(amount));
    }
}
