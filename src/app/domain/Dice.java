package app.domain;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int sides;

    /*
     * Constructor
     */
    public Dice(int selectedSides) {
        this.sides = selectedSides;
    }

    /*
     * This method will roll the 6 sided dice
     */
    public int rollDice(int selectedSides) {
        sides = selectedSides;
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }
}