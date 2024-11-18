package monster;

import units.Unit;
import units.Upgrade;

public class Dragon extends Unit implements Upgrade {

	private int count;

	public Dragon() {
		super("드래곤", (300 + upgradeHp), (20 + upgradeAtt), (10 + upgradeDef), (15 + upgradeExp));
	}

	@Override
	public void upgrade() {
		if (count % 3 == 0 && count != 0) {
			upgradeHp += 30;
			upgradeAtt += 5;
			upgradeDef += 5;
			upgradeExp += 5;
		}
	}

}
