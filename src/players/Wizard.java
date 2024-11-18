package players;

import units.Unit;
import units.Upgrade;

public class Wizard extends Unit implements Upgrade {

	public Wizard() {
		super(units.Unit.newName("마법사"), 100, 150, units.Unit.newAtt(), units.Unit.newDef(), 10);
	}

	@Override
	public void upgrade(Unit unit) {
		if (unit instanceof Wizard) {
			Wizard archer = (Wizard) unit;

			while (archer.MAX_EXP <= archer.exp) {
				if (archer.MAX_EXP <= archer.exp) {
					archer.exp -= archer.MAX_EXP;
					archer.level++;

					upgradeHp += 5;
					upgradeMp += 15;
					upgradeAtt += 10;
					upgradeDef += 3;
					upgradeExp += 3;
				}
			}
		}
	}
}
