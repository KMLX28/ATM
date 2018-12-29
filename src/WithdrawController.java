import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;

import java.io.IOException;

public class WithdrawController extends Transaction {


    // *********************************** Variables *******************************
    int amount;

    // *********************************** GUI Variables *******************************
    @FXML
    private Label insufficientFundsLabel;

    @FXML
    private ImageView errorIcon;

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView exitIcon;

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
        backIcon.setImage(blueBackIcon);
    }

    @FXML
    void backExited(MouseEvent event) {
        backIcon.setOpacity(0.75);
        backIcon.setImage(originalBackIcon);
    }
    // *********************************** GUI Actions *******************************

    @FXML
    void anotherAmountButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/AnotherAmount.fxml"));
        fxmlLoader.load();
        Stage stage = Main.getMainStage();
        stage.setTitle("Another amount");
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        stage.setScene(Main.getMainScene());
        stage.show();

    }


    @FXML
    void n1000Pressed(ActionEvent event) {
        amount = 1000;
        execute();

    }

    @FXML
    void n100Pressed(ActionEvent event) {
        amount = 100;
        execute();

    }

    @FXML
    void n200Pressed(ActionEvent event) {
        amount = 200;
        execute();

    }

    @FXML
    void n500Pressed(ActionEvent event) {
        amount = 500;
        execute();

    }

    @FXML
    void n50Pressed(ActionEvent event) {
        amount = 50;
        execute();

    }

    // *********************************** Initialize *******************************

    @FXML
    void initialize() {}


    // *********************************** Methods *******************************

    @Override
    public void execute() {

        if (amount <= MainMenuController.getBankDatabase().getTotalBalance(getCurrentAccountNumber())) {
            MainMenuController.getBankDatabase().debit(getCurrentAccountNumber(), amount);
            MainMenuController.getBankDatabase().saveDatabase(getBankDatabase().getAccount(getCurrentAccountNumber()));
            showAfterTransactionScene();
        } else {

            insufficientFundsLabel.setVisible(true);
            errorIcon.setVisible(true);

        }

    }

    @Override
    public void showAfterTransactionScene() {

        try {
            Main.getMainStage().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/AfterTransaction.fxml"));
            fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new BorderlessScene(stage, StageStyle.UNDECORATED, fxmlLoader.getRoot(), 600, 400);
            stage.setScene(scene);
            stage.setTitle("After Transaction");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
