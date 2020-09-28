package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor tooYoung;
    Visitor ofAge;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        tooYoung = new Visitor(17, 1.66, 5.00);
        ofAge = new Visitor(18, 1.70, 10.00);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void oldEnoughToSmoke() {
        assertTrue(tobaccoStall.isAllowed(ofAge));
    }

    @Test
    public void tooYoungToSmoke() {
        assertFalse(tobaccoStall.isAllowed(tooYoung));
    }
}
