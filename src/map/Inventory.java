package map;

public class Inventory extends Map implements Runnable {

	private boolean isInventory = true;

	@Override
	public void run() {
		while (isInventory) {
			try {
				System.out.println("=====[INVENTORY]=====");
				System.out.println("[1. 장비] [2. 가방] [3. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
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
			System.out.println("가방을 닫았습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isInventory = false;
			lobbyThread.start();
			break;
		default:
			System.err.println("메뉴 잘못 입력했습니다.");
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
