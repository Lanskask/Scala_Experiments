package codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataFighterTest {

    @Test
    public void declareWinner() {
        assertEquals(
                "Lew",
                KataFighter.declareWinner(
                        new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Lew")
        );

        assertEquals(
                "Harry",
                KataFighter.declareWinner(
                        new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Harry")
        );

        assertEquals(
                "Harald",
                KataFighter.declareWinner(
                        new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harry")
        );

        assertEquals(
                "Harald",
                KataFighter.declareWinner(
                        new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harald")
                );

        assertEquals(
                "Harald",
                KataFighter.declareWinner(
                        new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Jerry")
        );

        assertEquals(
                "Harald",
                KataFighter.declareWinner(
                        new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Harald")
                );
    }

}