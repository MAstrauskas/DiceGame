package app.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnInstruction;

    @FXML
    private Button btnExit;

    @FXML
    void onStartClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/NameSubmissionPage.fxml"));

        Loader(loader);
    }

    @FXML
    void onInstructionClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/InstructionPage.fxml"));

        Loader(loader);

    }

    @FXML
    void onExitClicked(ActionEvent event) {
        Platform.exit();
    }

    static void Loader(FXMLLoader loader) {
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
