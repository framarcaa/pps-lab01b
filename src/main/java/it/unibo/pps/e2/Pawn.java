package it.unibo.pps.e2;

public class Pawn implements Piece{
    private Pair<Integer, Integer> position;

    @Override
    public void setPosition(Pair<Integer,Integer> pos) {
        this.position = pos;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
