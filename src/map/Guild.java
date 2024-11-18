package map;

import units.Unit;

public class Guild extends Map implements Runnable {

	private boolean isGuild = true;

	@Override
	public void run() {
		while (isGuild) {
			try {
				System.out.println("=====[GUILD]=====");
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
		switch (select) {
		case "조회":
			inquiry();
			break;
		case "영입":
			recruit();
			break;
		case "추방":
			deport();
			break;
		case "종료":
			System.out.println("길드메뉴룰 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isGuild = false;
			lobbyThread.start();
			break;
		}
	}

	private void inquiry() {
		if (date.PlayerGuild.playerGuild.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}
		printGuild();
	}

	private void printGuild() {
		int count = 1;
		for (Unit i : date.PlayerGuild.playerGuild) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", date.PlayerGuild.playerGuild.size());
	}

	private void recruit() {
		// TODO Auto-generated method stub

	}

	private void deport() {
		// TODO Auto-generated method stub

	}

}
