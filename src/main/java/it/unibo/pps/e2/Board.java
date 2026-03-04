package it.unibo.pps.e2;

public interface Board {
    boolean positionIsInBoard(Pair<Integer, Integer> pos);

    int getSize();
}
