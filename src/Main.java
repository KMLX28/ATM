import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;

import java.io.IOException;

public class Main extends Application {

    // *********************************** Variables *******************************

    private static Stage mainStage;
    private static BorderlessScene mainScene;

    // *********************************** Getters and Setters *******************************

    // getter to access the main scene in every controller
    static BorderlessScene getMainScene() {
        return mainScene;
    }

    // getter to access the main stage in every controller
    static Stage getMainStage() {
        return mainStage;
    }

    // *********************************** run Method *******************************

    @Override
    public void start(Stage stage) throws IOException {

        loginScene(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }


    // *********************************** Scenes Methods *******************************

    private void loginScene(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLs/Login.fxml"));
        fxmlLoader.load();
        mainStage = stage;
        mainScene = new BorderlessScene(mainStage, StageStyle.UNDECORATED, fxmlLoader.getRoot(), 1000, 750);
        mainScene.setResizable(false);
        mainScene.removeDefaultCSS();

        mainStage.setScene(mainScene);
        mainStage.show();


    }
}