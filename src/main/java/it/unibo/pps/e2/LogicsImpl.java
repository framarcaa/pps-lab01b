package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pawn pawn;
	private final Knight knight;
	private final Random random = new Random();
	private final int size;

    public LogicsImpl(int size, Pawn pawn, Knight knight) {
        this.size = size;
        this.pawn = pawn;
        this.knight = knight;
    }

    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new Pawn();
        this.pawn.setPosition(this.randomEmptyPosition());
        this.knight = new Knight();
        this.knight.setPosition(this.randomEmptyPosition());
    }

	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn.getPosition()!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
        return this.knight.canMove(row, col, this.pawn);
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
