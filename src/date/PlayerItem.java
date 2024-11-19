package date;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import items.Item;
import units.Unit;

public class PlayerItem {
	private static HashMap<String, Item> intemMap;

	public static BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void equip(Item item) {
		intemMap.put(item.getName(), item);
		Inventory.remove(item);
		input(item.getName() + "이(가) 장착되었습니다.");
	}

	public static void unequip(Item item) {
		intemMap.remove(item);
		input(item.getName() + "이(가) 해제되었습니다.");
	}

	public static void printPlayreItem(Unit unit) {
		input(unit.name + "의 장비 목록:");
		for (String key : intemMap.keySet()) {
			Item item = intemMap.get(key);
			input(key + "\t");
			input(item);
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
