package de.jonas.snake.game;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Die Bewegung der Schlange wird berechnet und die des Apfels.
 */
public class CalculateSnake {

    /** Die einzelnen Körperteile der Schlange und deren Position und Richtung. */
    public static final HashMap<Integer, SnakeMovementState> SNAKE_FIELDS = new HashMap<>();

    /** Die Zeit in Millisekunden, in der der Berechnungs-timer läuft. */
    private static final int TIMER_INTERVAL = 500;
    /** Nach wie vielen Timer-Intervallen wird die Position des Apfels neu berechnet. */
    private static final int APPLE_TELEPORT_INTERVAL = 6;

    /** Die Position des Apfels. */
    @Getter
    private static int applePosition;

    /**
     * Der Haupt-Timer, mit dem alle Abläufe im Spiel berechnet werden.
     */
    public CalculateSnake() {
        final int[] appleCount = {0};
        changeApplePosition();
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                appleCount[0]++;

                if (appleCount[0] == APPLE_TELEPORT_INTERVAL) {
                    appleCount[0] = 0;
                    changeApplePosition();
                }

                for (final Map.Entry<Integer, SnakeMovementState> snake : SNAKE_FIELDS.entrySet()) {
                    final int field = snake.getKey();
                    final SnakeMovementState state = snake.getValue();
                    SNAKE_FIELDS.put(field + state.getIndex(), state);
                    if (state == SnakeMovementState.NONE) continue;
                    SNAKE_FIELDS.remove(field);
                }

            }
        }, 0, TIMER_INTERVAL);
    }

    private void changeApplePosition() {
        applePosition = ThreadLocalRandom.current().nextInt(0, GameDraw.LINES * GameDraw.SQUARES_PER_LINE + 1);
    }

}
