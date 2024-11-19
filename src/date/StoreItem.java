package date;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import items.Item;

public class StoreItem {
	public static BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));

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
		for (int i = 0; i < inventory.size(); i++) {
			input(i + "1번 아이템");
			input(inventory.get(i));
		}
	}

	public static void input(Object object) {
		try {
			wirter.append(object + "\n");
			wirter.flush();
		} catch (Exception e) {
		}
	}
}
