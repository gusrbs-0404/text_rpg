package date;

import java.util.ArrayList;

import items.Item;

public class StoreItem {
	public static ArrayList<Item> inventory = new ArrayList<>();

	public static void add(Item item) {
		inventory.add(item);
	}

	public static void remove(Item item) {
		inventory.remove(item);
	}

	public static void clear() {
		inventory.clear();
	}

	public static void printInventory() {
		for(int i=0; i<inventory.size(); i++) {
			inventory.get(i);
		}
	}
}
