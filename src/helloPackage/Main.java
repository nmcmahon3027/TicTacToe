package helloPackage;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame ticTacToe = new TicTacToeFrame();
        ticTacToe.setTitle("Tic Tac Toe [by Team Beard]");
        ticTacToe.setSize(700, 700);//original:600, 600
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }


}







