package date;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import items.Item;

public class PlayerItem {
	private String name;
	private HashMap<String, Item> intemMap;
	
	public BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));

	public void equip(Item item) {
		intemMap.put(item.getName(), item);
		input(item.getName() + "이(가) 장착되었습니다.");
	}

	public void unequip(String itemName) {
		intemMap.remove(itemName);
		input(itemName + "이(가) 해제되었습니다.");
	}

	public void showEquipment() {
		input(name + "의 장비 목록:");
		for (Item equipment : intemMap.values()) {
			input("- " + equipment.getName() + " (공격력: " + equipment.getAttack() + ", 방어력: " + equipment.getDefense()
					+ ", 가격: " + equipment.getPrice() + ")");
		}
	}

	public void input(String msg) {
		try {
			wirter.append(msg + "\n");
			wirter.flush();
		} catch (Exception e) {
		}
	}
}
