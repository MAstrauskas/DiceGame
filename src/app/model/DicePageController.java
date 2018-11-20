package app.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.Arrays;

import app.domain.Dice;
import app.domain.Player;

public class DicePageController {
    private final int MAX_SCORE = 50;
    private Dice dice;
    private Player p1;
    private int score;

    public DicePageController() {
        this.dice = new Dice(6);
        this.p1 = new Player();
    }

    @FXML
    private Label currentScore;

    @FXML
    private ListView listView;

    @FXML
    private Button PlayerOne;

    @FXML
    private Label totalScore;

    @FXML
    void playerOneClicked(ActionEvent event) {
        listView.getItems().clear();

        int[] rollDice = new int[3];

        for (int i = 0; i < 3; i++) {
            rollDice[i] = dice.rollDice(6);
            listView.getItems().add(rollDice[i]);
        }

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
        currentScore.setText(Integer.toString(score));
        p1.addScore(score);
        totalScore.setText(Integer.toString(p1.getScore()));
    }

    public void setText(String name) {
        PlayerOne.setText(name);
    }

}
