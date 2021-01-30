package de.jonas.snake.start;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;

import java.awt.Image;

/**
 * Lädt alle benötigten Bilder, für das {@link StartGUI Start-Fenster}.
 */
public final class ImageLoader {

    //<editor-fold desc="STATIC-FIELDS">
    /** Das Titel-Bild. */
    static Image TITLE;
    //</editor-fold>

    /**
     * Erstellt eine neue und vollständig unabhängige Instanz des {@link ImageLoader} und lädt alle Bilder.
     */
    @SneakyThrows
    public ImageLoader() {
        TITLE = ImageIO.read(getClass().getResource("/SnakeTitle.jpg"));
    }

}
