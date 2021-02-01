package de.jonas.snake.start;

import lombok.Getter;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;

import java.awt.Image;

/**
 * Lädt alle benötigten Bilder, für das {@link StartGUI Start-Fenster}.
 */
public final class ImageLoader {

    //<editor-fold desc="STATIC-FIELDS">
    /** Das Titel-Bild. */
    @Getter
    private static Image title;
    //</editor-fold>

    /**
     * Erstellt eine neue und vollständig unabhängige Instanz des {@link ImageLoader} und lädt alle Bilder.
     */
    @SneakyThrows
    public ImageLoader() {
        title = ImageIO.read(getClass().getResource("/snakeTitle.jpg"));
    }

}
