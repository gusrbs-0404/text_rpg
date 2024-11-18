package players;

import units.Unit;

public class Archer extends Unit {

	public Archer() {
		super(units.Unit.getName("궁수"), 100, 100, units.Unit.getAtt(), units.Unit.getDef());
	}
	
}
