package de.jonas.snake.game;

import de.jonas.snake.GUI;

/**
 * Das Fenster, in dem das Snake-Spiel angezeigt wird.
 */
public class GameGUI extends GUI {

    /** Die Breite des Fensters. */
    private static final int WIDTH = 600;
    /** Die Höhe des Fensters. */
    private static final int HEIGHT = 600;
    /** Die Aktion, die beim Schließen des Fensters ausgeführt wird. */
    private static final int CLOSE_OPERATION = 3;
    /** Der Titel des Fensters. */
    private static final String TITLE = "Snake - by Jonas";

    /**
     * Erzeugt eine neue Instanz des {@link GameGUI Snake-Fensters}.
     */
    public GameGUI() {
        super(WIDTH, HEIGHT, CLOSE_OPERATION, TITLE, false);

        new CalculateSnake();

        SnakeMovementState.setMovementState(SnakeMovementState.TOP);

        CalculateSnake.SNAKE_FIELDS.put((GameDraw.LINES * GameDraw.SQUARES_PER_LINE) / 2 + 1, SnakeMovementState.NONE);

        GameDraw draw = new GameDraw();
        draw.setBounds(0, 0, super.getWidth(), super.getHeight());
        draw.setVisible(true);

        super.addKeyListener(new KeyHandler());
        super.add(draw);
        super.openFrame();
    }

}
