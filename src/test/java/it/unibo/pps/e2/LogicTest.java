package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    Logics logic;
    private final int SIZE = 5;

    @BeforeEach
    public void init() {
        Pawn pawn = new Pawn();
        pawn.setPosition(new Pair<>(0, 0));
        Knight knight = new Knight();
        knight.setPosition(new Pair<>(1, 2));
        logic = new LogicsImpl(SIZE, pawn, knight);
    }
    @Test
    public void testPawnInBoard() {
        boolean flagPawn = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logic.hasPawn(i, j)) {
                    flagPawn = true;
                }
            }
        }
        assertTrue(flagPawn);
    }

    @Test
    public void testKnightInBoard() {
        boolean flagKnight = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logic.hasKnight(i, j)) {
                    flagKnight = true;
                }
            }
        }
        assertTrue(flagKnight);
    }

    @Test
    public void testPawnHitByKnight() {
        assertTrue(this.logic.hit(0, 0));
    }

    @Test
    public void testPawnNotHitByKnight() {
        assertFalse(this.logic.hit(0, 1));
    }

    @Test
    public void testKnightIllegalMove() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(6,6));
    }
}
