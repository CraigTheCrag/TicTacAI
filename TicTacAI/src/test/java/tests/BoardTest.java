package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import board.GameBoard;
import icon.BoardIcon;

public class BoardTest {
    
    private static final Logger logger = Logger.getLogger(BoardTest.class);
    
    @Rule
    public Timeout globalTimeout = new Timeout(2, TimeUnit.MINUTES);
    
    @Test
    public void testAddIcon() {
	
	GameBoard testBoard = new GameBoard();
	
	testBoard.editPos(0, 0, BoardIcon.CROSS);
	testBoard.editPos(1, 1, BoardIcon.NOUGHT);
	
	BoardIcon[][] correctBoard = new BoardIcon[][] {{BoardIcon.CROSS, BoardIcon.BLANK, BoardIcon.BLANK},
	    {BoardIcon.BLANK, BoardIcon.NOUGHT, BoardIcon.BLANK}, {BoardIcon.BLANK, BoardIcon.BLANK, BoardIcon.BLANK}};
	
	GameBoard correctTestBoard = new GameBoard(correctBoard);
	    
	    
	assertThat(testBoard, equalTo(correctTestBoard));
    }

}
