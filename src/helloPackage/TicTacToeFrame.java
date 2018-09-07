package helloPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicTacToeFrame extends JFrame {

    //indicate whose turn it is
    private char whoseTurn = 'X';
    public boolean gameOver = false; //private

    //create cell grid
    private Cell[][] cells = new Cell[3][3];//2d array, 3 x 3 grid

    //create a status label
    JLabel jlblStatus = new JLabel("X's turn to go");//text on label

    public TicTacToeFrame() { //Constructor(no args)
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));

        //fills grid panels w/ new cells
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                panel.add(cells[i][j] = new Cell());

        panel.setBorder(new LineBorder(Color.red, 1));
        jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

        add(panel, BorderLayout.CENTER);//adds panel to frame
        add(jlblStatus, BorderLayout.SOUTH);

    }

    //returns true if game board is full, false otherwise
    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cells[i][j].getToken() == ' ')
                    return false;
        return true;
    }

    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++)
            if ((cells[i][0].getToken() == token)
                    && (cells[i][1].getToken() == token)
                    && (cells[i][2].getToken() == token)) {
                return true;


            }
        // check columns
        for (int j = 0; j < 3; j++)
            if ((cells[0][j].getToken() == token)
                    && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token)) {
                return true;
            }
        // check diagonal
        if ((cells[0][0].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][2].getToken() == token)) {
            return true;
        }

        if ((cells[0][2].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][0].getToken() == token)) {
            return true;
        }

        return false;
    }

    /**
     * Defines a cell in TicTacToe game board.
     */
    public class Cell extends JPanel {
        // token of this cell
        private char token = ' ';

        /**
         * Constructor
         */
        public Cell() {
            setBorder(new LineBorder(Color.blue, 4));//black, 1
            addMouseListener(new MyMouseListener());
        }

        /**
         * Gets the token of the cell.
         *
         * @return The token value of the cell.
         */
        public char getToken() {
            return token;
        }

        /**
         * Sets the token of the cell.
         *
         * @param c Character to used as token value.
         */
        public void setToken(char c) {
            token = c;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (token == 'X') {
                g.drawLine(30, 30, getWidth() - 30, getHeight() - 30);
                g.drawLine(getWidth() - 30, 30, 30, getHeight() - 30);
            } else if (token == 'O') {
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
        }

        private class MyMouseListener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameOver)
                    return;

                // if the cell is empty and the game is not over
                if (token == ' ' && whoseTurn != ' ')
                    setToken(whoseTurn);

                // Check game status
                if (isWon(whoseTurn)) {
                    jlblStatus.setText(whoseTurn + " won! Game over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else if (isFull()) {
                    jlblStatus.setText("Tie game! Game over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    jlblStatus.setText(whoseTurn + "'s turn.");
                }
            }
        } // end class MyMouseListener
    } //end class
}// end class TicTacToeFrame

