package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void tooSmallAndTooYoung() {
        Visitor visitor = new Visitor(10, 1.35, 5.00);
        assertFalse(rollerCoaster.isAllowed(visitor));
    }

    @Test
    public void tallEnoughButTooYoung() {
        Visitor visitor = new Visitor(10, 1.55, 5.00);
        assertFalse(rollerCoaster.isAllowed(visitor));
    }

    @Test
    public void oldEnoughButTooSmall() {
        Visitor visitor = new Visitor(15, 1.35, 5.00);
        assertFalse(rollerCoaster.isAllowed(visitor));
    }

    @Test
    public void oldEnoughAndTallEnoughToRide() {
        Visitor visitor = new Visitor(15, 1.55, 5.00);
        assertTrue(rollerCoaster.isAllowed(visitor));
    }
}
