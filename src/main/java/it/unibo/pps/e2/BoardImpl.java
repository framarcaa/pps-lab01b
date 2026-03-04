package it.unibo.pps.e2;

public class BoardImpl implements Board {
    private int size;

    public BoardImpl(int size) {
        this.size = size;
    }

    @Override
    public boolean positionIsInBoard(Pair<Integer, Integer> pos) {
        return pos.getX() < 0 || pos.getY() < 0 || pos.getX() >= this.size || pos.getY() >= this.size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
