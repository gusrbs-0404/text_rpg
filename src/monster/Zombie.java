package monster;

import units.Unit;
import units.Upgrade;

public class Zombie extends Unit implements Upgrade {

	private int count;

	public Zombie() {
		super("좀비", (100 + upgradeHp), (10 + upgradeAtt), (5 + upgradeDef), (5 + upgradeExp));
	}

	@Override
	public void upgrade(Unit unit) {
		if (count % 3 == 0 && count != 0) {
			upgradeHp += 10;
			upgradeAtt += 5;
			upgradeDef += 5;
			upgradeExp += 5;
		}
	}
}
