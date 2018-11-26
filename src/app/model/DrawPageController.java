package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class DrawPageController {


    @FXML
    void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/NameSubmissionPage.fxml"));
        MainMenuController.Loader(loader);
    }

    @FXML
    void onMainMenuClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MainMenuPage.fxml"));
        MainMenuController.Loader(loader);
    }

}
