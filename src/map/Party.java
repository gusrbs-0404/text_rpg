package map;

import java.util.ArrayList;

import units.Unit;

public class Party extends Map implements Runnable {

	private boolean isParty = true;

	private ArrayList<Unit> party = date.PlayerParty.party;

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
			System.out.println("파티메뉴를 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isParty = false;
			lobbyThread.start();
			break;
		default:
			System.err.println("메뉴 잘못 입력했습니다.");
			break;
		}
	}

	private void inquiry() {
		if (party.size() == 0) {
			System.err.println("파티원이 없습니다.");
			return;
		}
		printParty();
	}

	private void printParty() {
		int count = 1;
		for (Unit i : party) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", party.size());
	}

	private void recruit() {
		

	}

	private void deport() {
		// TODO Auto-generated method stub

	}

}
