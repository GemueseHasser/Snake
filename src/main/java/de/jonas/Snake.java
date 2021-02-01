package de.jonas;

import de.jonas.snake.start.ImageLoader;
import de.jonas.snake.start.StartGUI;

/**
 * Die Haupt- und Main-Klasse der Anwendung.
 */
public class Snake {

    /**
     * Main-Methode, die ausgeführt wird, sobald die Anwendung gestartet wird.
     *
     * @param args .
     */
    public static void main(final String[] args) {
        // load Images for start-screen
        new ImageLoader();
        // open start-screen
        new StartGUI();
    }

}
