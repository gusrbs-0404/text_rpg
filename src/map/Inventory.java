package map;

import java.util.ArrayList;

import items.Item;
import units.Unit;

public class Inventory extends Map implements Runnable {
	private ArrayList<Unit> party = date.PlayerParty.party;
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
		printParty();
		// 장비 확인할 파티원 선택하고
		// 장비 보여주고
		// 장비 장착 해제할꺼 선택하고
		// 해제하기
		
		try {
			input("장비 확인할 파티원 선택 : ");
			String playerNumber = reader.readLine();
			
			
		} catch (Exception e) {
		}
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
			String itemNumber = reader.readLine();
			int number = inputNumber(itemNumber);
			install(number);
			if(number == -1) {
				return;
			}
		} catch (Exception e) {
		}
	}

	private int getPartyPlIndex(String number) {
		try {
			// 파티플레이어 선택 메소드
			if (party.size() == 0) {
				input("파티원이 없습니다.");
			}
			
			int num = -1;
			try {
				num = Integer.parseInt(number) - 1;
				if (num < 0 || num >= party.size()) {
					input("잘못입력했습니다.");
				}
			} catch (Exception e) {
			}
			return num;

		} catch (Exception e) {
			return -1;
		}
	}

	private int inputNumber(String number) {
		// 플레이어마다 착용중인 장비들 따로 출력하기
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= date.Inventory.size()) {
				input("잘못입력했습니다.");
			}

			if (date.Inventory.getItem(num).name.equals("몬스터 정수")) {
				input("몬스터 정수는 착용 할 수 없습니다.");
			}
		} catch (Exception e) {
			return -1;
		}
		return num;
	}
	
	private void install(int number) {
		try {
			printParty();
			// 장착할 장비 아이템 선택하고
			input("장비 확인할 파티원 선택 : ");
			String playerNumber = reader.readLine();
			// 파티원 선택
			int playerIndex = getPartyPlIndex(playerNumber);
			
			System.out.println(playerIndex);
			// 장비 장착 
			Unit.equipItem(date.Inventory.getItem(number), playerIndex);
			Unit.showStats(playerIndex);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void print(ArrayList<Item> item) {
		for (int i = 0; i < item.size(); i++) {
			input(i + 1 + "번 아이템");
			input(item.get(i));
		}
	}

	private void printParty() {
		int count = 1;
		for (Unit i : party) {
			input(count++ + "번 | ");
			input(i);
		}
		input("총인원 수 : " + party.size());
	}
}
