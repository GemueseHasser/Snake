package de.jonas.snake;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.Component;
import java.awt.event.KeyListener;

/**
 * Mit Hilfe dieser Klasse, lässt sich ein einfaches GUI erzeugen.
 */
public class GUI {

    //<editor-fold desc="LOCAL-FIELDS">
    /** Das {@link JFrame Fenster}, welches durch diese Instanz erzeugt wird. */
    private final JFrame frame;
    /** Die Breite des Fensters. */
    @Getter
    private final int width;
    /** Die Höhe des Fensters. */
    @Getter
    private final int height;
    //</editor-fold>

    //<editor-fold desc="CONSTRUCTOR">

    /**
     * Erzeugt ein leeres und vollständig unabhängiges {@link GUI Fenster}. Dieses Fenster kann bevor es geöffnet wird,
     * noch bearbeitet werden.
     *
     * @param width          Die Breite des Fensters.
     * @param height         Die Höhe des Fensters.
     * @param closeOperation Die Aktion, die beim Schließen erfolgt.
     * @param title          Der Titel des Fensters.
     * @param undecorated    Ist das fenster undekoriert oder nicht.
     */
    public GUI(
        @Range(from = 0, to = Integer.MAX_VALUE) final int width,
        @Range(from = 0, to = Integer.MAX_VALUE) final int height,
        @Range(from = 0, to = Integer.MAX_VALUE) final int closeOperation,
        @NotNull final String title,
        final boolean undecorated
    ) {
        this.width = width;
        this.height = height;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(closeOperation);
        frame.setBounds(0, 0, width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setUndecorated(undecorated);
        frame.setVisible(false);
    }
    //</editor-fold>

    /**
     * Öffnet das Fenster.
     */
    public void openFrame() {
        frame.setVisible(true);
    }

    /**
     * Schließt das Fenster.
     */
    public void closeFrame() {
        frame.dispose();
    }

    /**
     * Fügt einen bestimmten {@link Component Komponenten} zu dem Fenster hinzu.
     *
     * @param component Der {@link Component Komponent}, der hinzugefügt wird.
     */
    public void add(@NotNull final Component component) {
        frame.add(component);
    }

    /**
     * Setzt den entsprechenden {@link Border Rahmen} um das Fenster.
     *
     * @param border Der {@link Border Rahmen}.
     */
    public void setBorder(@NotNull final Border border) {
        frame.getRootPane().setBorder(border);
    }

    /**
     * Fügt den Entsprechenden {@link KeyListener Tasten-Listener} zu dem Fenster hinzu.
     *
     * @param listener Der {@link KeyListener}, der hinzugefügt wird.
     */
    public void addKeyListener(@NotNull final KeyListener listener) {
        frame.addKeyListener(listener);
    }

}
