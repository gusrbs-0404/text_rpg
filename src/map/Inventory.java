package map;

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
		// TODO Auto-generated method stub

	}

	private void inventory() {
		// TODO Auto-generated method stub

	}

}
