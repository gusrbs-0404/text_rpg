package players;

import units.Unit;
import units.Upgrade;

public class Warrior extends Unit implements Upgrade {

	public Warrior() {
		super(units.Unit.getName("전사"), 150, 100, units.Unit.getAtt(), units.Unit.getDef(), 10);
	}

	@Override
	public void upgrade(Unit unit) {
		if (unit instanceof Warrior) {
			Warrior archer = (Warrior) unit;

			while (archer.MAX_EXP <= archer.exp) {
				if (archer.MAX_EXP <= archer.exp) {
					archer.exp -= archer.MAX_EXP;
					archer.level++;

					upgradeHp += 20;
					upgradeMp += 10;
					upgradeAtt += 3;
					upgradeDef += 3;
					upgradeExp += 3;
				}
			}
		}
	}
}
