package attractions;

import people.Visitor;

public class Dodgems extends Attraction {

    private double price;

    public Dodgems(String name, int rating) {
        super(name, rating);
        this.price = 4.50;
    }

    public double defaultPrice() {
        return this.price;
    }

    public double priceFor(Visitor visitor) {
        double multiplier = 1;
        if (visitor.getAge() < 12) {
            multiplier -= 0.5;
        }
        return defaultPrice() * multiplier;
    }

}
