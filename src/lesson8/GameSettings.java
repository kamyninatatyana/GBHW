package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {

    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH-100;
    private static final int WINDOW_HEIGHT = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    static final int MODE_H_VS_A = 0;
    static final int MODE_H_VS_H = 1;

    private GameWindow gameWindow;

    private JRadioButton radioButtonHvsAi = new JRadioButton("Human vs Ai", true);
    private JRadioButton radioButtonHvsH = new JRadioButton("Human vs Human");
    private ButtonGroup gameMode = new ButtonGroup();

    private JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

    private Font fontLabel = new Font("Arial",Font.BOLD, 18);
    private Color RED_NEW = new Color(193,15,24);
    private Font fontButton = new Font("Arial", Font.BOLD,16);

    public GameSettings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Game Settings");

        setLayout(new GridLayout(8, 1));

        JLabel modeSetUp = new JLabel("Select Game Mode");
        modeSetUp.setHorizontalAlignment(SwingConstants.CENTER);
        modeSetUp.setFont(fontLabel);
        add(modeSetUp);

        add(radioButtonHvsAi);
        add(radioButtonHvsH);
        gameMode.add(radioButtonHvsAi);
        gameMode.add(radioButtonHvsH);


        JLabel fieldSizeSetUp = new JLabel("Select field's size:");
        fieldSizeSetUp.setHorizontalAlignment(SwingConstants.CENTER);
        fieldSizeSetUp.setFont(fontButton);
        add(fieldSizeSetUp);

        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setPaintTicks(true);
        add(sliderFieldSize);

        JLabel dotsToWinSetUp = new JLabel("Select dots to win:");
        dotsToWinSetUp.setHorizontalAlignment(SwingConstants.CENTER);
        dotsToWinSetUp.setFont(fontButton);
        add(dotsToWinSetUp);

        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setPaintTicks(true);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(e -> {
            sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
        });

        JButton buttonStartNewGame = new JButton("Start new game");
        buttonStartNewGame.setBackground(RED_NEW);
        buttonStartNewGame.setForeground(Color.WHITE);
        buttonStartNewGame.setFont(fontButton);
        add(buttonStartNewGame);

        buttonStartNewGame.addActionListener(e -> {
            setVisible(false);

            int mode;
            if (radioButtonHvsAi.isSelected()) {
                mode = MODE_H_VS_A;
            } else {
                mode = MODE_H_VS_H;
            }

            int fieldSize = sliderFieldSize.getValue();
            int dotsToWin = sliderDotsToWin.getValue();

            GameLogic.SIZE = fieldSize;
            GameLogic.DOTS_TO_WIN = dotsToWin;
            GameLogic.initMap();
            GameLogic.isGameOver = false;

            GameWindow.myPanel.setVisible(false);



            gameWindow.startNewGame(mode,fieldSize, fieldSize, dotsToWin);


        });

        setVisible(false);
    }

}
