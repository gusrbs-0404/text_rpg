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
		input(item.getName() + "이(가) 장착되었습니다.");
	}

	public static void unequip(Item item) {
		intemMap.remove(item);
		input(item.getName() + "이(가) 해제되었습니다.");
	}

	public static void printPlayreItem(Unit unit) {
		input(unit.name + "의 장비 목록:");
		
	}

	public static void input(String msg) {
		try {
			wirter.append(msg + "\n");
			wirter.flush();
		} catch (Exception e) {
		}
	}
}
