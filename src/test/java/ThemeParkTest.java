import attractions.Attraction;
import attractions.Dodgems;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.Stall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;

    @Before
    public void before() {
        themePark = new ThemePark();
    }

    @Test
    public void hasAttractionsList() {
        assertEquals(0, themePark.getAttractions().size());
    }

    @Test
    public void addSingleAttraction() {
        Attraction rollerCoaster =  new RollerCoaster("Loop-de-loopy", 5);
        themePark.addAttraction(rollerCoaster);
        assertEquals(1, themePark.getAttractions().size());
    }

    @Test
    public void addManyAttractions() {
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add( new RollerCoaster("Loop-de-loopy", 5));
        attractions.add(new Dodgems("Bumpy-bump", 4));
        themePark.setAttractions(attractions);
        assertEquals(2, themePark.getAttractions().size());
    }

    @Test
    public void hasStallsList() {
        assertEquals(0, themePark.getStalls().size());
    }

    @Test
    public void addSingleStall() {
        Stall candyfloss =  new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3);
        themePark.addStall(candyfloss);
        assertEquals(1, themePark.getStalls().size());
    }

    @Test
    public void addManyStalls() {
        ArrayList<Stall> stalls = new ArrayList<>();
        stalls.add(new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3));
        stalls.add(new IceCreamStall("Nice Creams", "Kevin", ParkingSpot.B3, 4));
        themePark.setStalls(stalls);
        assertEquals(2, themePark.getStalls().size());
    }

    @Test
    public void getReviewed() {
        Attraction rollerCoaster = new RollerCoaster("Loop-de-loopy", 5);
        themePark.addAttraction(rollerCoaster);
        Stall candyfloss =  new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3);
        themePark.addStall(candyfloss);
        assertEquals(2, themePark.getAllReviewed().size());
    }

}
