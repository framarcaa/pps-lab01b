package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pawn pawn;
	private final Knight knight;
    private final Board board;
	private final Random random = new Random();
	private final int SIZE = 5;

    public LogicsImpl(Pawn pawn, Knight knight) {
        this.pawn = pawn;
        this.knight = knight;
        this.board = new BoardImpl(SIZE);
    }

    public LogicsImpl(){
        this.board = new BoardImpl(SIZE);
        this.pawn = new Pawn();
        this.pawn.setPosition(this.randomEmptyPosition());
        this.knight = new Knight();
        this.knight.setPosition(this.randomEmptyPosition());
    }

	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(this.board.getSize()),this.random.nextInt(this.board.getSize()));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn.getPosition()!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (this.board.positionIsInBoard(new Pair<>(row, col))) {
			throw new IndexOutOfBoundsException();
		}
        if (this.knight.canMove(row, col, this.pawn)) {;
            return this.pawn.getPosition().equals(this.knight.getPosition());
        }
        return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
