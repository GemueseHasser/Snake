package de.jonas.snake.start;

import org.jetbrains.annotations.NotNull;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Malt den Hintergrund und das Titel-Bild des {@link StartGUI Start-Fensters}.
 */
public class StartDraw extends JLabel {

    @Override
    public void paintComponent(@NotNull final Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // change color to dark-gray
        g.setColor(Color.DARK_GRAY);

        // set background dark-gray
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        repaint();
    }

}
