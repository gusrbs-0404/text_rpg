package date;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import items.Item;

public class StoreItem {
	public static BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static ArrayList<Item> storeItem = new ArrayList<>();

	public static void add(Item item) {
		storeItem.add(item);
	}

	public static void remove(Item item) {
		storeItem.remove(item);
	}

	public static void clear() {
		storeItem.clear();
	}

	public static void printStoreItem() {
		for (int i = 0; i < storeItem.size(); i++) {
			input(i + 1 + "번 아이템");
			input(storeItem.get(i));
		}
	}

	public static int getPrice(int index) {
		return storeItem.get(index).price;
	}

	public static String getName(int index) {
		return storeItem.get(index).name;
	}

	public static int size() {
		return storeItem.size();
	}

	public static void input(Object object) {
		try {
			wirter.append(object + "\n");
			wirter.flush();
		} catch (Exception e) {
		}
	}
}
