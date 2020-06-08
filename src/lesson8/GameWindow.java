package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 400;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;

    private GameSettings gameSetting;
    private ButtleMap buttleMap;

    public GameWindow() {
        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        gameSetting = new GameSettings(this);
        buttleMap = new ButtleMap(this);
        add(buttleMap, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartNewGame = new JButton("Start new game");
        buttonStartNewGame.setBackground(Color.CYAN);
        panel.add(buttonStartNewGame);

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBackground(Color.PINK);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e-> {
            System.exit(0);
        });

        buttonStartNewGame.addActionListener(e -> {
            gameSetting.setVisible(true);
        });

        setVisible(true);
        }

        public void startNewGame (int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
            // System.out.printf("gameMode: %d, fieldSizeX: %d, fieldSizeY: %d, dotsToWin: %d\n",
            //        gameMode, fieldSizeX, fieldSizeY, dotsToWin);
            buttleMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, dotsToWin);
        }
    }



