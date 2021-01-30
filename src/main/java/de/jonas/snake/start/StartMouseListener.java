package de.jonas.snake.start;

import org.jetbrains.annotations.NotNull;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Dieser {@link MouseListener} sorgt dafür, dass sich die Hintergundfarbe des jeweiligen Buttons beim herüber-hovern
 * ändert.
 */
public class StartMouseListener implements MouseListener {

    //<editor-fold desc="LOCAL-FIELDS">
    /** Der Button, dessen Hintergrundfarbe beim herüber-hovern geändert wird. */
    private final JButton button;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTOR">
    /**
     * Erzeugt eine neue Instanz des {@link StartMouseListener}.
     * @param button Der Button, um den es geht.
     */
    public StartMouseListener(@NotNull final JButton button) {
        this.button = button;
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(final MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
        // change background-color to red
        button.setBackground(Color.RED);
    }

    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
        // change background-color to light-gray
        button.setBackground(Color.LIGHT_GRAY);
    }
    //</editor-fold>
}
