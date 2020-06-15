package lesson8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GameLogic extends JFrame {

    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;
    static boolean isGameOver = false;

    static Random random = new Random();
    static Font fontLabel = new Font("Arial", Font.BOLD, 35);
    static Color RED_NEW = new Color(177, 14, 17);
    static Color GRAY_NEW = new Color(10, 16, 16);

    public static void go() {

        JFrame frame = new JFrame("Game is Over!");
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 200);

        JPanel panel = new JPanel(new BorderLayout());

        frame.add(panel, BorderLayout.CENTER);

        JButton buttonOK = new JButton("OK");
        buttonOK.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonOK.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(panel);
        frame.add(buttonOK, BorderLayout.SOUTH);

        buttonOK.addActionListener(e -> {
            frame.setVisible(false);
            return;
        });

        isGameOver = true;


        if (checkWinLines(DOT_X)) {

            panel.setBackground(RED_NEW);

            JLabel sayWhoIsWinner = new JLabel("You win!");

            sayWhoIsWinner.setHorizontalAlignment(SwingConstants.CENTER);
            sayWhoIsWinner.setFont(fontLabel);
            sayWhoIsWinner.setForeground(GRAY_NEW);
            panel.add(sayWhoIsWinner, BorderLayout.CENTER);

            frame.setVisible(true);
            return;
        }

        if (isFull()) {

            panel.setBackground(Color.WHITE);

            JLabel sayWhoIsWinner = new JLabel("It's a draw!");

            sayWhoIsWinner.setHorizontalAlignment(SwingConstants.CENTER);
            sayWhoIsWinner.setFont(fontLabel);
            sayWhoIsWinner.setForeground(RED_NEW);
            panel.add(sayWhoIsWinner, BorderLayout.CENTER);

            frame.setVisible(true);
            return;

        }

        aiTurn();

        if (checkWinLines(DOT_O)) {
            panel.setBackground(GRAY_NEW);

            JLabel sayWhoIsWinner = new JLabel("Computer wins!");

            sayWhoIsWinner.setHorizontalAlignment(SwingConstants.CENTER);
            sayWhoIsWinner.setFont(fontLabel);
            sayWhoIsWinner.setForeground(RED_NEW);
            panel.add(sayWhoIsWinner, BorderLayout.CENTER);

            frame.setVisible(true);
            return;
        }

        if (isFull()) {
            panel.setBackground(Color.WHITE);

            JLabel sayWhoIsWinner = new JLabel("It's a draw!");

            sayWhoIsWinner.setHorizontalAlignment(SwingConstants.CENTER);
            sayWhoIsWinner.setFont(fontLabel);
            sayWhoIsWinner.setForeground(RED_NEW);
            panel.add(sayWhoIsWinner, BorderLayout.CENTER);

            frame.setVisible(true);
            return;

        }

        isGameOver = false;
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }


    public static void setHumanCoords(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        /*System.out.println("1");*/
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                       /* System.out.println("2");*/
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    if (isCellValid(i + 1, j)) {
                        map[i + 1][j] = DOT_O;
                       /* System.out.println("7");*/
                        return;
                    }
                    if (isCellValid(i, j + 1)) {
                        map[i][j + 1] = DOT_O;
                        /*System.out.println("8");*/
                        return;
                    }
                    if (isCellValid(i - 1, j)) {
                        map[i - 1][j] = DOT_O;
                       /* System.out.println("9");*/
                        return;
                    }
                    if (isCellValid(i, j - 1)) {
                        map[i][j - 1] = DOT_O;
                       /* System.out.println("10");*/
                        return;
                    }
                    if (isCellValid(i - 1, j - 1)) {
                        map[i - 1][j - 1] = DOT_O;
                        /*System.out.println("11");*/
                        return;
                    }
                    if (isCellValid(i + 1, j + 1)) {
                        map[i + 1][j + 1] = DOT_O;
                       /* System.out.println("12");*/
                        return;
                    }
                    if (isCellValid(i - 1, j + 1)) {
                        map[i - 1][j + 1] = DOT_O;
                       /* System.out.println("13");*/
                        return;
                    }
                    if (isCellValid(i + 1, j - 1)) {
                        map[i + 1][j - 1] = DOT_O;
                       /* System.out.println("14");*/
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_O) {
                    if (isCellValid(i + 1, j)) {
                        map[i + 1][j] = DOT_O;
                        /*System.out.println("15");*/
                        return;
                    }
                    if (isCellValid(i, j + 1)) {
                        map[i][j + 1] = DOT_O;
                      /*  System.out.println("16");*/
                        return;
                    }
                    if (isCellValid(i - 1, j)) {
                        map[i - 1][j] = DOT_O;
                        /*System.out.println("17");*/
                        return;
                    }
                    if (isCellValid(i, j - 1)) {
                        map[i][j - 1] = DOT_O;
                       /* System.out.println("18");*/
                        return;
                    }
                    if (isCellValid(i - 1, j - 1)) {
                        map[i - 1][j - 1] = DOT_O;
                        /*System.out.println("19");*/
                        return;
                    }
                    if (isCellValid(i + 1, j + 1)) {
                        map[i + 1][j + 1] = DOT_O;
                       /* System.out.println("20");*/
                        return;
                    }
                    if (isCellValid(i - 1, j + 1)) {
                        map[i - 1][j + 1] = DOT_O;
                        /*System.out.println("21");*/
                        return;
                    }
                    if (isCellValid(i + 1, j - 1)) {
                        map[i + 1][j - 1] = DOT_O;
                        /*System.out.println("22");*/
                        return;
                    }
                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * (DOTS_TO_WIN - 1) > SIZE - 1 ||
                cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }
}



















