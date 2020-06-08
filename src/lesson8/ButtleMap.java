package lesson8;

import javax.swing.*;
import java.awt.*;

public class ButtleMap extends JPanel {
    private GameWindow gameWindow;

    public ButtleMap (GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);
    }
        public void startNewGame (int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
            System.out.printf("gameMode: %d, fieldSizeX: %d, fieldSizeY: %d, dotsToWin: %d\n",
                    gameMode, fieldSizeX, fieldSizeY, dotsToWin);
        }
    }


