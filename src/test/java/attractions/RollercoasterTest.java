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

    @Test
    public void hasPrice() {
        Visitor visitor = new Visitor(15, 1.80, 50.00);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void tallVisitorGetsUnfairlyChargedDouble() {
        Visitor tall = new Visitor(20, 2.05, 10.00);
        assertEquals(16.8, rollerCoaster.priceFor(tall), 0.01);
    }

    @Test
    public void incrementVisitCount() {
        rollerCoaster.incrementVisitCount();
        assertEquals(1, rollerCoaster.getVisitCount());
    }

}
