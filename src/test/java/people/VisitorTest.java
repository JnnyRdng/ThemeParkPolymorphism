package people;

import attractions.Attraction;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void hasVisitedAttractionsList() {
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void addVisitedAttraction() {
        Attraction attraction = new RollerCoaster("Oblivion", 5);
        visitor.visit(attraction);
        assertEquals(1, visitor.getVisitedAttractions().size());
    }
}
