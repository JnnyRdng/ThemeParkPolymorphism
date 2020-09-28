import attractions.Attraction;
import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

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
        themePark.add(rollerCoaster);
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
        themePark.add(candyfloss);
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
        themePark.add(rollerCoaster);
        Stall candyfloss =  new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3);
        themePark.add(candyfloss);
        assertEquals(2, themePark.getAllReviewed().size());
    }

    @Test
    public void visitAttraction() {
        Attraction rollerCoaster = new RollerCoaster("Oblivion", 5);
        Visitor visitor = new Visitor(20, 1.85, 60.00);
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(rollerCoaster, visitor.getVisitedAttractions().get(0));
    }

    @Test
    public void hashMapOfReviewed() {
        Attraction rollerCoaster = new RollerCoaster("Loop-de-loopy", 5);
        themePark.add(rollerCoaster);
        Stall candyfloss =  new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3);
        themePark.add(candyfloss);
        HashMap<String, Integer> reviews = themePark.getAllReviews();
        assertEquals((Integer) 5, reviews.get("Loop-de-loopy"));
        assertEquals((Integer) 3, reviews.get("Floss Is Boss"));
    }

    @Test
    public void canGetAllAVisitorIsAllowedOn() {
        Attraction rollerCoaster = new RollerCoaster("Loop-de-loopy", 5);
        themePark.add(rollerCoaster);
        Stall candyfloss =  new CandyflossStall("Floss Is Boss", "Keith", ParkingSpot.A1, 3);
        themePark.add(candyfloss);
        Stall tobaccoStall = new TobaccoStall("Tomacco", "Homer", ParkingSpot.B4, 5);
        themePark.add(tobaccoStall);
        Attraction playground = new Playground("Super Fun World", 2);
        themePark.add(playground);
        Visitor visitor = new Visitor(17, 1.50, 10.00);
        assertEquals(2, themePark.getAllAllowedFor(visitor).size());
        assertEquals(rollerCoaster, themePark.getAllAllowedFor(visitor).get(0));
        assertEquals(candyfloss, themePark.getAllAllowedFor(visitor).get(1));
    }

}
