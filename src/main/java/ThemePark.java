import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> reviewed;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        this.reviewed = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void setStalls(ArrayList<Stall> stalls) {
        this.stalls = stalls;
    }

    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        for (Attraction attraction : attractions) {
            if (attraction instanceof IReviewed) {
                this.reviewed.add(attraction);
            }
        }
        for (Stall stall : stalls) {
            if (stall instanceof IReviewed) {
                this.reviewed.add(stall);
            }
        }
        return this.reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.incrementVisitCount();
        visitor.visit(attraction);
    }
}