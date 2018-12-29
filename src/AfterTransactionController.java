import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class AfterTransactionController {

    @FXML
    private JFXButton mainMenuButton;

    @FXML
    private JFXButton exitButton;



    @FXML
    void mainMenuButtonPressed(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/MainMenu.fxml"));
        fxmlLoader.load();
        Main.getMainScene().setRoot(fxmlLoader.getRoot());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Main.getMainStage().show();
        Main.getMainStage().setScene(Main.getMainScene());

    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void initialize() {

    }
}
