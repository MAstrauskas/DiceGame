package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import app.domain.Player;

public class NameSubmissionController {
    public Player p1;

    @FXML
    private TextField textField_pName;

    @FXML
    private Label pName;

    @FXML
    private Pane mainPane;

    @FXML
    private Button btnSubmit;

    @FXML
    void onSubmitClicked(ActionEvent event) {
        p1 = new Player(textField_pName.getText());
        String name = textField_pName.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Signup Successful!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DicePage.fxml"));

        try {
            Parent root = (Parent) loader.load();
            DicePageController sc = loader.getController();
            sc.setText(name);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
