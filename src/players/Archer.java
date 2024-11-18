package players;

import units.Unit;
import units.Upgrade;

public class Archer extends Unit implements Upgrade {

	public Archer() {
		super(units.Unit.getName("궁수"), 100, 100, units.Unit.getAtt(), units.Unit.getDef(), 10);
	}

	@Override
	public void upgrade(Unit unit) {
		if (unit instanceof Archer) {
			Archer archer = (Archer) unit;

			while (archer.MAX_EXP <= archer.exp) {
				if (archer.MAX_EXP <= archer.exp) {
					archer.exp -= archer.MAX_EXP;
					archer.level++;

					upgradeHp += 10;
					upgradeMp += 10;
					upgradeAtt += 5;
					upgradeDef += 3;
					upgradeExp += 3;
				}
			}
		}
	}
}
