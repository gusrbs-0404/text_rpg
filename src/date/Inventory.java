package date;

import java.util.ArrayList;

import items.Item;

public class Inventory {
	public static ArrayList<Item> inventory = new ArrayList<>();

	public static void add(Item item) {
		inventory.add(item);
	}

	public static void remove(Item item) {
		inventory.remove(item);
	}

	public static int size() {
		return inventory.size();
	}

	public static Item getItem(int index) {
		return inventory.get(index);
	}
}
