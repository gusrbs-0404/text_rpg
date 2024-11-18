package map;

public class Party extends Map implements Runnable {

	private boolean isParty = true;

	@Override
	public void run() {
		while (isParty) {
			try {
				System.out.println("=====[PARTY]=====");
				System.out.println("[1. 조회] [2. 영입] [3. 추방] [4. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {

		if (select.equals("조회")) {
			inquiry();
		} else if (select.equals("영입")) {
			recruit();
		} else if (select.equals("추방")) {
			deport();
		} else if (select.equals("종료")) {
			System.out.println("파티메뉴를 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isParty = false;
			lobbyThread.start();
		}

	}

	private void inquiry() {
		// TODO Auto-generated method stub

	}

	private void recruit() {
		// TODO Auto-generated method stub

	}

	private void deport() {
		// TODO Auto-generated method stub

	}

}
