package de.jonas.snake.game;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Die Bewegung der Schlange wird berechnet und die des Apfels.
 */
public class CalculateSnake {

    /** Die zuletzt berechnete Position der Schlange (des Kopfes). */
    public static final HashMap<Integer, SnakeMovementState> LAST_SNAKE_TURN_POSITION = new HashMap<>();
    /** Der Kopf der Schlange und dessen Position und Richtung. */
    public static final HashMap<Integer, SnakeMovementState> SNAKE_FIELD = new HashMap<>();
    /** Die einzelnen Körperteile der Schlange. */
    public static final ConcurrentHashMap<Integer, SnakeMovementState> TAIL_FIELDS = new ConcurrentHashMap<>();
    /** Die Zeit in Millisekunden, in der der Berechnungs-Timer läuft. */
    private static final int TIMER_INTERVAL = 250;
    /** Nach wie vielen Timer-Intervallen wird die Position des Apfels neu berechnet. */
    private static final int APPLE_TELEPORT_INTERVAL = 12;


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
                checkCollision();

                for (final Map.Entry<Integer, SnakeMovementState> snake : SNAKE_FIELD.entrySet()) {
                    final int field = snake.getKey();
                    final SnakeMovementState state = snake.getValue();
                    SNAKE_FIELD.put(field + state.getIndex(), state);
                    if (state == SnakeMovementState.NONE) continue;
                    SNAKE_FIELD.remove(field);
                }

                for (final Map.Entry<Integer, SnakeMovementState> tail : TAIL_FIELDS.entrySet()) {
                    for (final Map.Entry<Integer, SnakeMovementState> lastPosition :
                        LAST_SNAKE_TURN_POSITION.entrySet()
                    ) {
                        if (tail.getKey() + tail.getValue().getIndex() == lastPosition.getKey()) {
                            TAIL_FIELDS.put(
                                tail.getKey() + tail.getValue().getIndex(),
                                lastPosition.getValue()
                            );
                        } else {
                            TAIL_FIELDS.put(
                                tail.getKey() + tail.getValue().getIndex(),
                                tail.getValue()
                            );
                        }
                        TAIL_FIELDS.remove(tail.getKey());
                    }
                }

                appleCount[0]++;

                if (appleCount[0] == APPLE_TELEPORT_INTERVAL) {
                    appleCount[0] = 0;
                    changeApplePosition();
                }
            }
        }, 0, TIMER_INTERVAL);
    }

    private void changeApplePosition() {
        applePosition = ThreadLocalRandom.current().nextInt(0, GameDraw.LINES * GameDraw.SQUARES_PER_LINE + 1);
    }

    private void checkCollision() {
        for (final Map.Entry<Integer, SnakeMovementState> snake : SNAKE_FIELD.entrySet()) {
            // collision with apple
            if (snake.getKey() == applePosition) {
                System.out.println("collision");
                int headField = snake.getKey();
                TAIL_FIELDS.put(
                    headField - (
                        (TAIL_FIELDS.size() == 0)
                        ? snake.getValue().getIndex()
                        : (TAIL_FIELDS.size() + 1) * snake.getValue().getIndex()
                    ),
                    snake.getValue()
                );
                changeApplePosition();
            }
        }
    }

}
