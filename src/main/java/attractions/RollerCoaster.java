package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {


    private double price;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
        this.price = 8.40;
    }

    public boolean isAllowed(Visitor visitor) {
        return visitor.getHeight() > 1.45 && visitor.getAge() > 12;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        double multiplier = 1;
        if (visitor.getHeight() >= 2.00) {
            multiplier++;
        }
        return defaultPrice() * multiplier;
    }
}
