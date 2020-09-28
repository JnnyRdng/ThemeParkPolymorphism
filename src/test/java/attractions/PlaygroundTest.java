package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor youngUn;
    Visitor oldMan;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        youngUn = new Visitor(10, 1.35, 50.00);
        oldMan = new Visitor(18, 1.64, 9.99);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void tooOldToGetIn() {
        assertFalse(playground.isAllowed(oldMan));
    }

    @Test
    public void youngEnoughToEnter() {
        assertTrue(playground.isAllowed(youngUn));
    }
}
