package items;

public class Item {
	public String name;
	public int attack;
	public int defense;
	public int price;

	public Item(String name, int attack, int defense, int price) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.price = price;
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
}
