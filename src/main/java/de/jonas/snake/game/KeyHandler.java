package de.jonas.snake.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * Die Richtung wird berechnet.
 */
public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        for (final Map.Entry<Integer, SnakeMovementState> snake : CalculateSnake.SNAKE_FIELD.entrySet()) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                snake.setValue(SnakeMovementState.LEFT);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setValue(SnakeMovementState.RIGHT);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                snake.setValue(SnakeMovementState.TOP);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                snake.setValue(SnakeMovementState.DOWN);
            }
            CalculateSnake.LAST_SNAKE_TURN_POSITION.clear();
            CalculateSnake.LAST_SNAKE_TURN_POSITION.put(
                snake.getKey(),
                snake.getValue()
            );
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }
}
