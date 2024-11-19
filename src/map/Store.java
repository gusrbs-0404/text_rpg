package map;

public class Store extends Map implements Runnable {

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
			break;
		}
		case "판매": {
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

	private void purchase() {
		// TODO Auto-generated method stub
 
	}

	private void sale() {
		// TODO Auto-generated method stub

	}

}
