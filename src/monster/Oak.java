package monster;

import units.Unit;
import units.Upgrade;

public class Oak extends Unit implements Upgrade {

	private int count;

	public Oak() {
		super("오크", (200 + upgradeHp), (15 + upgradeAtt), (7 + upgradeDef), (10 + upgradeExp));
	}

	@Override
	public void upgrade(Unit unit) {
		if (count % 3 == 0 && count != 0) {
			upgradeHp += 20;
			upgradeAtt += 5;
			upgradeDef += 5;
			upgradeExp += 5;
		}
	}
}
