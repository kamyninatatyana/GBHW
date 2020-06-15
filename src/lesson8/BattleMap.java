package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;

    int basicWidth = 10;
    int basicSize = 3;
    double penWidth = ((double) basicSize / (double) GameLogic.SIZE) * (double) basicWidth;
    BasicStroke pen1 = new BasicStroke(Math.round(penWidth));

    private Color RED_NEW = new Color(177,14,17);

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.white);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!GameLogic.isGameOver){
            GameLogic.setHumanCoords(cellX, cellY);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < GameLogic.SIZE; i++) {
            for (int j = 0; j < GameLogic.SIZE; j++) {
                if(GameLogic.map[i][j]==GameLogic.DOT_X){
                    drawX(g, j, i);
                }
            }
        }


        for (int i = 0; i < GameLogic.SIZE; i++) {
            for (int j = 0; j < GameLogic.SIZE; j++) {
                if(GameLogic.map[i][j]==GameLogic.DOT_O){
                    drawO(g, j, i);
            }
        }
    }



}

    private void drawX(Graphics g, int cellX, int cellY) {


        Graphics2D g2 = (Graphics2D) g;
        ((Graphics2D) g).setStroke(pen1);


        g2.setColor(RED_NEW);

        g2.drawLine(cellX * cellWidth + cellWidth/4, cellY * cellHeight + cellHeight/4,
                (cellX + 1) * cellWidth - cellWidth/4, (cellY + 1) * cellHeight - cellHeight/4);
        g2.drawLine((cellX+1) * cellWidth - cellWidth/4, cellY * cellHeight + cellHeight/4,
                cellX * cellWidth + cellWidth/4, (cellY + 1) * cellHeight - cellHeight/4);
    }

    private void drawO(Graphics g, int cellX, int cellY) {


        Graphics2D g2 = (Graphics2D) g;


        g.drawOval(cellX * cellWidth+cellWidth/4, cellY * cellHeight+cellHeight/4, cellWidth/2, cellHeight/2);

   }


    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();


        }

    }




