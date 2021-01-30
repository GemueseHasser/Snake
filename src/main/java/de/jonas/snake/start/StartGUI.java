package de.jonas.snake.start;

import de.jonas.snake.GUI;
import de.jonas.snake.game.GameGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Das Start-Fenster, in dem man das Spiel starten kann.
 */
public class StartGUI extends GUI {

    //<editor-fold desc="CONSTANTS">
    /** Die Breite des Fensters. */
    private static final int WIDTH = 350;
    /** Die Höhe des Fensters. */
    private static final int HEIGHT = 450;
    /** Die Aktion, die beim Schließen des Fensters ausgeführt werden soll. */
    private static final int CLOSE_OPERATION = 3;
    /** Der Titel des Fensters. */
    private static final String TITLE = "Snake - by Jonas";
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTOR">
    /**
     * Erstelle eine neue Instanz des {@link StartGUI Start-Fensters}.
     */
    public StartGUI() {
        super(WIDTH, HEIGHT, CLOSE_OPERATION, TITLE, true);

        final StartDraw draw = new StartDraw();
        draw.setBounds(0, 0, super.getWidth(), super.getHeight());
        draw.setVisible(true);

        final JButton game = new JButton("Spielen");
        game.setBounds(23, 280, 300, 50);
        game.setOpaque(true);
        game.setBackground(Color.LIGHT_GRAY);
        game.addMouseListener(new StartMouseListener(game));
        game.setFocusable(false);
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                StartGUI.super.closeFrame();
                new GameGUI();
            }
        });

        final JButton exit = new JButton("Verlassen");
        exit.setBounds(23, 350, 300, 50);
        exit.setOpaque(true);
        exit.setBackground(Color.LIGHT_GRAY);
        exit.addMouseListener(new StartMouseListener(exit));
        exit.setFocusable(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        super.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        super.add(game);
        super.add(exit);
        super.add(draw);
        super.openFrame();
    }
    //</editor-fold>
}
