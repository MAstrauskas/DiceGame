package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class WelcomePageController {

    @FXML
    private Button btnSubmit;

    @FXML
    void onSubmitClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MainMenuPage.fxml"));

        MainMenuController.Loader(loader);
    }

}

