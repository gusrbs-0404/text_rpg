package date;

import java.util.ArrayList;

import items.Item;

public class Inventory {
	public static ArrayList<Item> inventory = new ArrayList<>();

	private static ArrayList<PlayerItem> items = new ArrayList<>();

	// 인벤토리
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

	// 장비장착
	public void addItem(PlayerItem item) {
		items.add(item);
	}

	public void showInventory() {
		System.out.println("인벤토리 목록:");
		for (PlayerItem item : items) {
			if (!item.isEquipped()) {
				System.out.println("- " + item.getName());
			}
		}
	}

	public PlayerItem getItem(String itemName) {
		for (PlayerItem item : items) {
			if (item.getName().equals(itemName) && !item.isEquipped()) {
				return item;
			}
		}
		return null;
	}
} 
