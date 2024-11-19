package date;

import java.util.ArrayList;
import items.Item;

public class StoreItem {

	public static ArrayList<Item> storeItem = new ArrayList<>();

	public static void add(Item item) {
		storeItem.add(item);
	}

	public static void clear() {
		storeItem.clear();
	}

	public static int getPrice(int index) {
		return storeItem.get(index).price;
	}

	public static String getName(int index) {
		return storeItem.get(index).name;
	}

	public static Item getItem(int index) {
		return storeItem.get(index);
	}

	public static int size() {
		return storeItem.size();
	}
}
