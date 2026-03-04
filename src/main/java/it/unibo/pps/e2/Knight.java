package it.unibo.pps.e2;

public class Knight implements Piece{
    private Pair<Integer, Integer> position;

    @Override
    public void setPosition(Pair<Integer,Integer> pos) {
        this.position = pos;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    public boolean canMove(int row, int col, Pawn pawn) {
        int x = row-this.position.getX();
        int y = col-this.position.getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            setPosition(new Pair<>(row, col));
            return pawn.getPosition().equals(this.position);
        }
        return false;
    }
}
