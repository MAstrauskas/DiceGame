package app.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Pane rootPane;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnInstruction;

    @FXML
    private Button btnExit;

    @FXML
    private void onStartClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/NameSubmissionPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void onInstructionClicked(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/app/view/InstructionPage.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void onExitClicked(ActionEvent event) {
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
