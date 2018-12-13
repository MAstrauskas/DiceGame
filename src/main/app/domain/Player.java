package main.app.domain;

public class Player {
    private String name;
    private int totalScore;

    /*
     * Default constructor
     */
    public Player() {

    }

    /*
     * Constructor
     */
    public Player(String playerName) {
        this.name = playerName;
        this.totalScore = 0;
    }

    /*
     * This method sets the name for the player
     */
    public void setPlayerName(String playerName) {
        this.name = playerName;
    }

    /*
     * This method gets the name for the player
     */
    public String getPlayerName() {
        return this.name;
    }

    /*
     * This method adds the new score to the current player's score
     */
    public void addScore(int newScore) {
        this.totalScore += newScore;
    }

    /*
     * This method shows the current score of the player
     */
    public int getScore() {
        return totalScore;
    }
}