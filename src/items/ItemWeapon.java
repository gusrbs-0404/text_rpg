package items;

public class ItemWeapon extends Item {
	public ItemWeapon(String name, int attack, int price, boolean equipable) {
		super(name, attack, 0, price, equipable);
	}
}
