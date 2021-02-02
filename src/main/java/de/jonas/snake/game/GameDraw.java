package de.jonas.snake.game;

import org.jetbrains.annotations.NotNull;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Map;

/**
 * Das Snake-Spiel wird gezeichnet.
 */
public class GameDraw extends JLabel {

    //<editor-fold desc="CONSTANTS">

    //<editor-fold desc="squares">
    /** Die Anzahl an Zeilen, in denen Kästchen gemalt werden sollen. */
    public static final int LINES = 15;
    /** Die Anzahl an Kästchen, die in einer Zeile gemalt werden sollen. */
    public static final int SQUARES_PER_LINE = 15;
    /** Die Größe, die ein jedes Quadrat hat. */
    private static final int SQUARE_SIZE = 30;
    /** Der Abstand von links, bei dem angefangen wird, die Kästchen zu zeichnen. */
    private static final int MARGIN_LEFT = 70;
    /** Der Abstand von oben, bei dem angefangen wird, die Kästchen zu zeichnen. */
    private static final int MARGIN_TOP = 60;
    /** Die X-Koordinaten, an denen die Kästchen gemalt werden sollen. */
    private static final int[] X = new int[LINES * SQUARES_PER_LINE + 1];
    /** Die Y-Koordinaten, an denen die Kästchen gemalt werden sollen. */
    private static final int[] Y = new int[LINES * SQUARES_PER_LINE + 1];
    //</editor-fold>

    //<editor-fold desc="apple">
    /** Die Größe des Apfels. */
    private static final int APPLE_SIZE = 15;
    /** Der Abstand von oben und links des Apfels. */
    private static final int APPLE_MARGIN = 8;
    //</editor-fold>

    //</editor-fold>

    /**
     * Es werden alle Koordinaten der Kästchen mithilfe der obigen Angaben von Zeilen, Quadraten per Zeile,
     * Quadrat-Größe und Abständen berechnet.
     */
    public GameDraw() {
        int x = MARGIN_LEFT;
        int y = MARGIN_TOP;

        X[0] = x;
        Y[0] = y;

        for (int i = 1; i < LINES * SQUARES_PER_LINE + 1; i++) {
            X[i] = x;
            Y[i] = y;

            x += SQUARE_SIZE;

            if (i % SQUARES_PER_LINE == 0) {
                x = MARGIN_LEFT;
                y += SQUARE_SIZE;
            }
        }
    }

    @Override
    public void paintComponent(@NotNull final Graphics g) {
        super.paintComponent(g);

        final Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);

        // draw squares
        for (int i = 0; i < X.length; i++) {
            g.drawRect(X[i], Y[i], SQUARE_SIZE, SQUARE_SIZE);
        }

        // draw snake
        for (final Map.Entry<Integer, SnakeMovementState> snake : CalculateSnake.SNAKE_FIELD.entrySet()) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(X[snake.getKey()], Y[snake.getKey()], SQUARE_SIZE, SQUARE_SIZE);
        }

        // draw tail
        for (final Map.Entry<Integer, SnakeMovementState> tail : CalculateSnake.TAIL_FIELDS.entrySet()) {
            g.setColor(Color.GREEN);
            g.fillRect(X[tail.getKey()], Y[tail.getKey()], SQUARE_SIZE, SQUARE_SIZE);
        }

        // draw apple
        g.setColor(Color.RED);
        g.fillOval(
            X[CalculateSnake.getApplePosition()] + APPLE_MARGIN,
            Y[CalculateSnake.getApplePosition()] + APPLE_MARGIN,
            APPLE_SIZE,
            APPLE_SIZE
        );

        repaint();
    }

}
