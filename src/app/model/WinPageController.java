package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class WinPageController {

    @FXML
    private Label winner;

    /*
     * Play Again button is clicked and user is redirected to NameSubmissionPage
     */
    @FXML
    void onPlayAgainClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/NameSubmissionPage.fxml"));
        MainMenuController.Loader(loader);
    }

    /*
     * Main Menu button is clicked and user is redirected to MainMenuPage
     */
    @FXML
    void onMainMenuClicked(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MainMenuPage.fxml"));
        MainMenuController.Loader(loader);
    }

    public void setWinnerName(String name) {
        winner.setText("Congratulations \n" + name + ",\n you have won!");
    }

}
