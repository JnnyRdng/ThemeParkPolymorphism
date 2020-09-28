package behaviours;

import people.Visitor;

public interface ISecurity {

    public boolean isAllowed(Visitor visitor);
}
