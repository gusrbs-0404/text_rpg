package players;

import units.Unit;

public class Warrior extends Unit {
	
	public Warrior() {
		super(units.Unit.getName("궁수"), 100, 100, units.Unit.getAtt(), units.Unit.getDef());
	}
}
