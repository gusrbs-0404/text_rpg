package map;

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
		// TODO Auto-generated method stub

	}

	private void recruit() {
		// TODO Auto-generated method stub

	}

	private void deport() {
		// TODO Auto-generated method stub

	}

}
