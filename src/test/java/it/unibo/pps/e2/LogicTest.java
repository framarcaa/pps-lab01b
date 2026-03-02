package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
    Logics logic;
    private final int SIZE = 5;
    @BeforeEach
    public void init() {
        logic = new LogicsImpl(SIZE);
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
                if (this.logic.hasPawn(i, j)) {
                    flagKnight = true;
                }
            }
        }
        assertTrue(flagKnight);
    }
}
