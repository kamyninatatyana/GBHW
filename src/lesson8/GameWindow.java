package lesson8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame {

    static final int WINDOW_POS_X = 400;
    static final int WINDOW_POS_Y = 400;
    static final int WINDOW_WIDTH = 400;
    static final int WINDOW_HEIGHT = 450;


    private GameSettings gameSetting;
    private BattleMap battleMap;


    private Color GRAY_NEW = new Color(10,16,16);
    private Color RED_NEW = new Color(177,14,17);
    private Font fontButton = new Font("Arial", Font.BOLD,16);

    static Image img = null;
    static MyPanel myPanel = new MyPanel();

    public GameWindow() {

        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartNewGame = new JButton("Start new game");
        buttonStartNewGame.setBackground(RED_NEW);
        buttonStartNewGame.setForeground(Color.WHITE);
        buttonStartNewGame.setFont(fontButton);
        panel.add(buttonStartNewGame);

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBackground(GRAY_NEW);
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setFont(fontButton);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        gameSetting = new GameSettings(this);
        battleMap = new BattleMap(this);

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        buttonStartNewGame.addActionListener(e -> {

            gameSetting.setVisible(true);
        });

        myPanel.setBounds(WINDOW_POS_X+50,WINDOW_POS_Y+50,WINDOW_WIDTH-50,WINDOW_HEIGHT-50);
        add(myPanel);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        add(battleMap, BorderLayout.CENTER);
        battleMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, dotsToWin);


    }

    static class MyPanel extends JPanel {

        MyPanel() {
            try {
                img = ImageIO.read(new File("D:/Обучение/GBHW/src/lesson8/6.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void paintComponent(Graphics gr) {
                         gr.drawImage(img, 20, 20, 350, 350, null);
            }
        }


}



