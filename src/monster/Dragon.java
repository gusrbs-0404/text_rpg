package monster;

import units.Unit;
import units.Upgrade;

public class Dragon extends Unit implements Upgrade {

	private int count;

	public Dragon() {
		super("드래곤", (300 + upgradeHp), (20 + upgradeAtt), (10 + upgradeDef), (15 + upgradeExp));
	}

	@Override
	public void upgrade(Unit unit) {
		if (count % 3 == 0 && count != 0) {
			upgradeHp += 30;
			upgradeAtt += 10;
			upgradeDef += 7;
			upgradeExp += 5;
		}
	}

}
