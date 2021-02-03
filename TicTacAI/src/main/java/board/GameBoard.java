package board;

import java.util.ArrayList;
import java.util.List;

import icon.BoardIcon;

public class GameBoard {
    
    private BoardIcon[][] board;
    private static final Integer DEFAULT_DIMENSIONS = 3;
    
    public GameBoard() {
	this.board = new BoardIcon[DEFAULT_DIMENSIONS][DEFAULT_DIMENSIONS];
	for (int i=0;i<DEFAULT_DIMENSIONS;i++) {
	    for (int j=0;j<DEFAULT_DIMENSIONS;j++) {
		this.board[i][j] = BoardIcon.BLANK;
	    }
	}
    }
    
    public GameBoard(GameBoard board) {
	this.board = board.getBoard();
    }
    
    public GameBoard(BoardIcon[][] board) {
	this.board = board;
    }
    
    public GameBoard editPos(Integer x, Integer y, BoardIcon icon) {
	this.board[x][y] = icon;
	return this;
    }
    
    public List<GameBoard> generateNextMoves(BoardIcon icon) {
	List<GameBoard> boards = new ArrayList<GameBoard>();
	BoardIcon[][] current;
	for (int i=0;i<this.board.length;i++) {
	    for (int j=0;j<this.board[i].length;j++) {
		if (this.board[i][j] != BoardIcon.BLANK) {
		    current = this.board.clone();
		    current[i][j] = icon;
		    boards.add(new GameBoard(current));
		}
	    }
	}
	return boards;
    }
    
    public String toString() {
	String b = "[";
	for (int i=0;i<this.board.length;i++) {
	    b += "[";
	    for (int j=0;j<this.board[i].length;j++) {
		b += this.board[i][j].toString() + "|";
	    }
	    b = b.substring(0, b.length()-1);
	    b += "]";
	}
	b += "]";
	return b;
    }
    
    public BoardIcon[][] getBoard() {
	return this.board;
    }
    
    public Boolean equals(GameBoard otherBoard) {
	for (int i=0;i<this.board.length;i++) {
	    for (int j=0;j<this.board[i].length;j++) {
		if (!this.board[i][j].equals(otherBoard.getBoard()[i][j])) {
		    return false;
		}
	    }
	}
	return true;
    }
}
