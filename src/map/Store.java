package map;

import java.util.ArrayList;

import date.StoreItem;
import items.Item;

public class Store extends Map implements Runnable {
	private final int WEAPON = 1;
	private final int ARMOR = 2;
	private final int MONSTERINTEGER = 3;

	private boolean isStore = true;

	@Override
	public void run() {
		isStore = true;
		while (isStore) {
			try {
				input("=====[STORE]=====");
				input("[1. 구매] [2. 판매] [3. 종료]");
				input("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {
		switch (select) {
		case "구매": {
			purchase();
			break;
		}
		case "판매": {
			sale();
			break;
		}
		case "종료": {
			input("상점에서 나왔습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isStore = false;
			lobbyThread.start();
			break;
		}
		default:
			input("메뉴 잘못 입력했습니다.");
			break;
		}
	}

	private void setStoreItem() {
		date.StoreItem.clear();
		for (int i = 0; i < 6; i++) {
			int ranNum = ran.nextInt(3) + 1;
			if (ranNum == WEAPON) {
				items.ItemWeapon weapon = new items.ItemWeapon("무기", ranAttack(), ranPrice());
				StoreItem.add(weapon);
			} else if (ranNum == ARMOR) {
				items.ItemArmor armor = new items.ItemArmor("갑옷", ranDefense(), ranPrice());
				StoreItem.add(armor);
			} else if (ranNum == MONSTERINTEGER) {
				items.ItemMonsterInteger armor = new items.ItemMonsterInteger("몬스터 정수", ranPrice());
				StoreItem.add(armor);
			}
		}
		print(date.StoreItem.storeItem);
	}

	private int ranAttack() {
		int ranAttack = ran.nextInt(20) + 1;
		return ranAttack;

	}

	private int ranDefense() {
		int ranDefense = ran.nextInt(15) + 1;
		return ranDefense;

	}

	private int ranPrice() {
		int ranPrice = ran.nextInt(5000) + 500;
		return ranPrice;
	}

	private void purchase() {
		setStoreItem();

		try {
			input("=====[STOREITEM]=====");
			input("구매할 아이템 번호 입력 : ");
			String number = reader.readLine();
			inputPurcgase(number);
		} catch (Exception e) {
		}
	}

	private void inputPurcgase(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= date.StoreItem.size()) {
				input("잘못입력했습니다.");
			}
		} catch (Exception e) {
			input("잘못입력했습니다.");
			return;
		}

		if (date.Price.getPrice() < date.StoreItem.getPrice(num)) {
			input("파티의 돈이 부족합니다!!!");
			return;
		}

		input(date.StoreItem.getName(num) + " 아이템을 구매합니다.");

		// 파티 소지금 뺴기 해야됨
		date.Price.minusPrice(date.StoreItem.getPrice(num));

		input("파티 소지금 : " + date.Price.getPrice());

		date.Inventory.add(date.StoreItem.getItem(num));
	}

	private void sale() {
		if (date.Inventory.size() == 0) {
			input("인벤토리에 아무것도 없다..");
			return;
		}
		// 판매
		// 인벤토리의 목록을 보여준다
		print(date.Inventory.inventory);

		try {
			input("=====[INVENTORY]=====");
			input("판매할 아이템 번호 입력 : ");
			String number = reader.readLine();
			inputSale(number);
		} catch (Exception e) {
		}

	}

	private void inputSale(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= date.Inventory.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		input(date.Inventory.getItem(num) + " 아이템을 판매합니다.");

		date.Price.plusPrice(date.Inventory.getItem(num).price);
		input("파티 소지금 : " + date.Price.getPrice());

		date.Inventory.remove(date.Inventory.getItem(num));
	}

	private void print(ArrayList<Item> item) {
		for (int i = 0; i < item.size(); i++) {
			input(i + 1 + "번 아이템");
			input(item.get(i));
		}
	}

}
