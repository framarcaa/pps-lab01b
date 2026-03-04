package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    @Test
    public void testKnightCanMove() {
        Knight knight = new Knight();
        knight.setPosition(new Pair<>(4, 4));
        Pawn pawn = new Pawn();
        pawn.setPosition(new Pair<>(1, 1));

        assertTrue(knight.canMove(2, 3, pawn));
    }

    @Test
    public void testKnightCantMove() {
        Knight knight = new Knight();
        knight.setPosition(new Pair<>(4, 4));
        Pawn pawn = new Pawn();
        pawn.setPosition(new Pair<>(1, 1));

        assertFalse(knight.canMove(2, 4, pawn));
    }
}
