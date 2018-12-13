package main.app.domain;

import javafx.scene.image.Image;

public class DiceImages {

    final Image dice1 = new Image(getClass().getResourceAsStream("/side1.jpg"));
    final Image dice2 = new Image(getClass().getResourceAsStream("/side2.jpg"));
    final Image dice3 = new Image(getClass().getResourceAsStream("/side3.jpg"));
    final Image dice4 = new Image(getClass().getResourceAsStream("/side4.jpg"));
    final Image dice5 = new Image(getClass().getResourceAsStream("/side5.jpg"));
    final Image dice6 = new Image(getClass().getResourceAsStream("/side6.jpg"));

    final Image[] images = new Image[6];

    public DiceImages() {
        images[0] = dice1;
        images[1] = dice2;
        images[2] = dice3;
        images[3] = dice4;
        images[4] = dice5;
        images[5] = dice6;
    }

    public Image getOneImage(int number) {
        return images[number - 1];
    }
}
