package de.jonas.snake.game;

import de.jonas.snake.GUI;

public class GameGUI extends GUI {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int CLOSE_OPERATION = 3;
    private static final String TITLE = "Snake - by Jonas";

    public GameGUI() {
        super(WIDTH, HEIGHT, CLOSE_OPERATION, TITLE, false);
        super.openFrame();
    }

}
