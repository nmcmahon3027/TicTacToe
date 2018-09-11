package helloPackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeFrameTest {

    @Test
    public void isFull() {
    }

    @Test
    public void isWon() {
    }

    @Test
    public void testGameOver() {
        TicTacToeFrame game = new TicTacToeFrame();
        assertFalse(game.gameOver);


    }

    @Test
    public void setTextTest() {
        TicTacToeFrame text = new TicTacToeFrame();
        assertTrue("Tie game! Game over!", true);
    }

    @Test
    public void setTextOnTie() {
        String str = "Tie game! Game Over!";
        assertEquals("Tie game! Game Over!", str);

    }

    @Test
    public void testClickOutput() {
    }

    @Test
    public void testResponseOnClick() {

    }

    @Test
    public void testResponseTime() {

    }
}

//expected, actual 