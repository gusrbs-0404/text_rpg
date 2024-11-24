package items;

public class Item {
	public String name;
	public int attack;
	public int defense;
	public int price;
	public boolean equipable;

	public Item(String name, int attack, int defense, int price, boolean equipable) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.price = price;
		this.equipable = equipable;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getPrice() {
		return price;
	}

	public boolean isEquipable() {
		return equipable;
	}

	@Override
	public String toString() {
		String msg = String.format("%s 장비 [공격력 : %d | 방어력 : %d]\n가격 : %d", name, attack, defense, price);
		return msg;
	}
}
