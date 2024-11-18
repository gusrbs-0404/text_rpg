package players;

import units.Unit;

public class Wizard extends Unit {

	public Wizard() {
		super(units.Unit.getName("마법사"), 100, 150, units.Unit.getAtt(), units.Unit.getDef());
	}
}
