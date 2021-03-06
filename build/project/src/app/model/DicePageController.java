package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.Arrays;

import app.domain.Dice;
import app.domain.Player;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DicePageController {
    private final int MAX_SCORE = 50;
    private Dice dice;
    private Player p1;
    private Player p2;
    private int score;
    private ActionEvent event;
    boolean firstPlayerTurn = true;
    private String wonPlayer;

    public DicePageController() {
        this.dice = new Dice(6);
        this.p1 = new Player();
        this.p2 = new Player();
        this.wonPlayer = "";
    }

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label p1_currentScore;

    @FXML
    private Label p2_currentScore;

    @FXML
    private ListView listView;

    @FXML
    private Label PlayerOne;

    @FXML
    private Label PlayerTwo;

    @FXML
    private Label p1_totalScore;

    @FXML
    private Label p2_totalScore;

    @FXML
    private Label playerTurn;

    @FXML
    private Label PlayerOneLeading;

    @FXML
    private Label PlayerTwoLeading;

    /*
     * Each time Player One clicks his/her button,
     * The score is updated
     */
    public void switchPlayer() {
        firstPlayerTurn = !firstPlayerTurn;
    }

    /*
     * When a button "Roll!" is pressed random dice numbers are rolled
     * and scores updated for each player in turn
     */
    @FXML
    void rollButtonClicked(ActionEvent event) {
        listView.getItems().clear();
        int[] rollDice = new int[3];
        checkWinOrDraw();
        if (firstPlayerTurn) {
            RollDiceAndShowNumbers(rollDice);
            scoreCalculation(rollDice);
            setPlayerScore(p1, p1_currentScore, p1_totalScore);
            leadingPlayer();
            playerTurn.setText(PlayerTwo.getText() + ",\n it's your turn!");
            switchPlayer();
        } else {
            RollDiceAndShowNumbers(rollDice);
            scoreCalculation(rollDice);
            setPlayerScore(p2, p2_currentScore, p2_totalScore);
            leadingPlayer();
            playerTurn.setText(PlayerOne.getText() + ",\n it's your turn!");
            switchPlayer();
        }
    }

    /*
     * Rolls the dice and shows the numbers on a list view
     */
    private void RollDiceAndShowNumbers(int[] rollDice) {
        for (int i = 0; i < 3; i++) {
            rollDice[i] = dice.rollDice(6);
            listView.getItems().add(rollDice[i]);
        }
    }

    /*
     * Method that is used in player turns methods
     * Updates the scores on each press of a button
     */
    private void scoreCalculation(int[] rollDice) {
        boolean flag = true;
        int first = rollDice[0];

        for (int i = 1; i < 3 && flag; i++) {
            if (rollDice[i] != first) flag = false;
        }
        if (flag) {
            score = 18;
        } else {
            Arrays.sort(rollDice);
            if (rollDice[0] == rollDice[1]) {
                score = rollDice[0] + rollDice[1];
            } else if (rollDice[1] == rollDice[2]) {
                score = rollDice[1] + rollDice[2];
            } else {
                score = 1;
            }
        }
    }

    /*
     * Sets the current and total scores for a Player
     */
    private void setPlayerScore(Player player, Label currentScore, Label totalScore) {
        currentScore.setText(Integer.toString(score));
        player.addScore(score);
        totalScore.setText(Integer.toString(player.getScore()));
    }
    /*
     * This method checks who have won or if it's a draw
     */
    private void checkWinOrDraw(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/WinPage.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/app/view/DrawPage.fxml"));

        if (p1.getScore() > MAX_SCORE && p2.getScore() > MAX_SCORE) {
            // Set Player Names
            try {
                Pane pane = loader2.load();
                DrawPageController drawPage = loader2.getController();
                drawPage.setPlayerNames(PlayerOne.getText(), PlayerTwo.getText());
                rootPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (p1.getScore() > MAX_SCORE) {
            try {
                Pane pane = loader.load();
                WinPageController winPage = loader.getController();
                winPage.setWinnerName(PlayerOne.getText());
                winPage.setPlayerNames(PlayerOne.getText(), PlayerTwo.getText());
                rootPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (p2.getScore() > MAX_SCORE) {
            try {
                Pane pane = loader.load();
                WinPageController winPage = loader.getController();
                winPage.setWinnerName(PlayerTwo.getText());
                winPage.setPlayerNames(PlayerOne.getText(), PlayerTwo.getText());
                rootPane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * Checks which player is leading
     */
    private void leadingPlayer() {
        if(p1.getScore() > p2.getScore()) {
            PlayerOneLeading.setText("You're ahead!");
            PlayerTwoLeading.setText("");
        }
        else if (p1.getScore() < p2.getScore()) {
            PlayerTwoLeading.setText("You're ahead!");
            PlayerOneLeading.setText("");
        }
    }

    /*
     * Sets the name of a button to Player One chosen name
     */
    public void setPlayerOneText(String name) {
        PlayerOne.setText(name);
    }

    /*
     * Sets the name of a button to Player Two chosen name
     */
    public void setPlayerTwoText(String name) {
        PlayerTwo.setText(name);
    }
}
