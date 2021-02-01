package de.jonas.snake.game;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Range;

/**
 * Die Richtung, in der sich die Schlange bewegt.
 */
public enum SnakeMovementState {

    /** Bewegung nach oben. */
    TOP(
        -15
    ),
    /** Bewegung nach links. */
    LEFT(
        -1
    ),
    /** Bewegung nach rechts. */
    RIGHT(
        1
    ),
    /** Bewegung nach unten. */
    DOWN(
        15
    ),
    /** Keine Bewegung am Anfang. */
    NONE(
        0
    );

    /** Der aktuelle Status der Bewegung. */
    @Getter
    @Setter
    private static SnakeMovementState movementState;

    /** Die Anzahl an Kästchen, die bei dem jeweiligen {@link SnakeMovementState Status} gegangen werden. */
    @Getter
    private final int index;

    SnakeMovementState(
        @Range(from = -15, to = 15) final int index
    ) {
        this.index = index;
    }

}
