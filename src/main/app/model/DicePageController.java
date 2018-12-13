package main.app.model;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.app.domain.Dice;
import main.app.domain.Player;
import main.app.domain.DiceImages;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class DicePageController  {
    private static int MAX_SCORE = 50;
    private Dice dice;
    private Player p1;
    private Player p2;
    private int score;
    private boolean firstPlayerTurn = true;
    public String wonPlayer;
    List<Integer> diceList;
    
    /*
     * Controller
     */
    public DicePageController() {
        this.dice = new Dice(6);
        this.p1 = new Player();
        this.p2 = new Player();
        this.wonPlayer = "";
        diceList = new ArrayList<Integer>();
    }

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label p1_currentScore;

    @FXML
    private Label p2_currentScore;

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

    @FXML
    private ImageView diceSide1;

    @FXML
    private ImageView diceSide2;

    @FXML
    private ImageView diceSide3;
    
    @FXML
    private Button rollButton;

    /*
     * Each time Player One clicks his/her button,
     * The score is updated
     */
    private void switchPlayer() {
        firstPlayerTurn = !firstPlayerTurn;
    }

    /*
     * When a button "Roll!" is pressed random dice numbers are rolled
     * and scores updated for each player in turn
     */
    @FXML
    public void rollButtonClicked(ActionEvent event) {
        int[] rollDice = new int[3];

        if (firstPlayerTurn) {
            RollDiceAndShowNumbers(rollDice);
            showCorrentDiceImages();
            scoreCalculation(rollDice);
            setPlayerScore(p1, p1_currentScore, p1_totalScore);
            diceList.clear();
            leadingPlayer();
            playerTurn.setText("Your turn,\n " + PlayerTwo.getText() + "!");
            switchPlayer();
        } else {
            RollDiceAndShowNumbers(rollDice);
            showCorrentDiceImages();
            scoreCalculation(rollDice);
            setPlayerScore(p2, p2_currentScore, p2_totalScore);
            diceList.clear();
            leadingPlayer();
            playerTurn.setText(PlayerOne.getText() + ",\n it's your turn!");
            switchPlayer();
            checkDrawOrWin();
        }
    }
    
    /*
     * Loads Name Submission page when Back is pressed 
     */
    @FXML
    public void backClicked(ActionEvent event) throws IOException {
    	Pane pane = FXMLLoader.load(getClass().getResource("/main/app/view/NameSubmissionPage.fxml"));
    	rootPane.getChildren().setAll(pane);
    }
    
    /*
     * Shows the dice sides that have been thrown
     */
    public void showCorrentDiceImages() {
       DiceImages images = new DiceImages(); 
 
       int side1 = diceList.get(0);
       int side2 = diceList.get(1);
       int side3 = diceList.get(2);
        
       diceSide1.setImage(images.getOneImage(side1));
       diceSide2.setImage(images.getOneImage(side2));
       diceSide3.setImage(images.getOneImage(side3));
    }

    /*
     * Rolls the dice and shows the numbers on a list view
     */
    private void RollDiceAndShowNumbers(int[] rollDice) {
        for (int i = 0; i < 3; i++) {
            rollDice[i] = dice.rollDice(6);
            diceList.add(rollDice[i]);
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
           scoreRules(rollDice);
        }
    }

    /*
     * Checks the score against the rules of the game
     */
    private void scoreRules(int[] rollDice) {
        Arrays.sort(rollDice);
        if (rollDice[0] == rollDice[1]) {
            score = rollDice[0] + rollDice[1];
        } else if (rollDice[1] == rollDice[2]) {
            score = rollDice[1] + rollDice[2];
        } else {
            score = 1;
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
    private void checkDrawOrWin() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/app/view/DrawPage.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/main/app/view/WinPage.fxml"));
        String winner;
        String looser;

        if (p1.getScore() > MAX_SCORE && p2.getScore() > MAX_SCORE) {
        	int playerOneScore = p1.getScore();
        	int playerTwoScore = p2.getScore();
            draw(loader, playerOneScore, playerTwoScore);
        } else if (p1.getScore() > MAX_SCORE) {
        	winner = PlayerOne.getText();
        	looser = PlayerTwo.getText();
        	int winnerScore = p1.getScore();
        	int looserScore = p2.getScore();
        	win(loader2, winner, looser, winnerScore, looserScore);
        } else if (p2.getScore() > MAX_SCORE) {
        	winner = PlayerTwo.getText();
        	looser = PlayerOne.getText();
        	int winnerScore = p2.getScore();
        	int looserScore = p1.getScore();
        	win(loader2, winner, looser, winnerScore, looserScore);
        }
    }
    
    /*
     * If draw, shows a draw page
     */
    public void draw(FXMLLoader loader, int playerOneScore, int playerTwoScore) {
    	 try {
             Pane pane = loader.load();
             fadeTransition(pane);
             DrawPageController drawPage = loader.getController();
             drawPage.setPlayerNames(PlayerOne.getText(), PlayerTwo.getText());
             drawPage.setPlayerScores(playerOneScore, playerTwoScore);
             rootPane.getChildren().setAll(pane);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    /*
     * If win, shows a win page and the winner becomes Player 1 next game
     */
    public void win(FXMLLoader loader, String winner, String looser, int winnerScore, int looserScore) {
    	 try {
             Pane pane = loader.load();
             fadeTransition(pane);
             WinPageController winPage = loader.getController();
             winPage.setWinnerName(winner);
             winPage.setPlayerNames(winner, looser);
             winPage.setPlayerScores(winnerScore, looserScore);
             rootPane.getChildren().setAll(pane);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    /*
     * Fades in selected page
     */
    private void fadeTransition(Pane pane) {
    	FadeTransition fadeIn = new FadeTransition(Duration.millis(3000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1);
        fadeIn.play();
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
