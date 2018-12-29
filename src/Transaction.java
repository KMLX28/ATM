import java.io.IOException;

public abstract class Transaction extends MainMenuController {

    abstract public void execute() throws IOException;
    abstract public void showAfterTransactionScene();

}
