package map;

public class Battle extends Map implements Runnable {

	private boolean isBattle = true;

	@Override
	public void run() {
		isBattle = true;
		while (isBattle) {
			try {
				System.out.println("=====[BATTLE]=====");
				System.out.println("[1. 좀비] [2. 오크(LV3↑)] [3. 드래곤(LV5↑)] [4. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {

			}
		}
	}

	private void menu(String select) {

		// 예외처리 - 파티 4명 다 모였을때 입장가능
		switch (select) {
		case "좀비":
			zombie();
			break;
		case "오크":
			oak();
			break;
		case "드래곤":
			dragon();
			break;
		case "종료":
			System.out.println("전투 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isBattle = false;
			lobbyThread.start();
			break;
	}

	private void zombie() {
		// TODO Auto-generated method stub

	}

	private void oak() {
		// TODO Auto-generated method stub

	}

	private void dragon() {
		// TODO Auto-generated method stub

	}

}
