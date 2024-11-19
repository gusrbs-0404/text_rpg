package map;

import java.util.ArrayList;

import items.Item;

public class Inventory extends Map implements Runnable {

	private boolean isInventory = true;

	@Override
	public void run() {
		while (isInventory) {
			try {
				input("=====[INVENTORY]=====");
				input("[1. 장비] [2. 가방] [3. 종료]");
				input("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {
		switch (select) {
		case "장비":
			equipment();
			break;
		case "가방":
			inventory();
			break;
		case "종료":
			input("가방을 닫았습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isInventory = false;
			lobbyThread.start();
			break;
		default:
			input("메뉴 잘못 입력했습니다.");
			break;
		}
	}

	private void equipment() {
		date.PlayerItem.printPlayreItem();
	}

	private void inventory() {
		if (date.Inventory.size() == 0) {
			System.out.println("인벤토리에 아무것도 없다..");
			return;
		}

		// 가방에 있는 장비들 보여준다
		print(date.Inventory.inventory);
		// 아이템 이름 입력하면 사용, 장착가능
		try {
			input("장착할 아이템 번호 입력 : ");
			String number = reader.readLine();
			install(number);
		} catch (Exception e) {
		}
	}

	private void install(String number) {
		// 플레이어마다 착용중인 장비들 따로 출력하기
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= date.Inventory.size()) {
				input("잘못입력했습니다.");
			}
			
			if(date.Inventory.getItem(num).name.equals("몬스터 정수")) {
				input("몬스터 정수는 착용 할 수 없습니다.");
			}

			date.PlayerItem.equip(date.Inventory.getItem(num));
		} catch (Exception e) {
			return;
		}

	}

	private void print(ArrayList<Item> item) {
		for (int i = 0; i < item.size(); i++) {
			input(i + 1 + "번 아이템");
			input(item.get(i));
		}
	}
}
