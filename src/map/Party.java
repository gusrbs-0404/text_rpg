package map;

import java.util.ArrayList;

import units.Unit;

public class Party extends Map implements Runnable {

	private boolean isParty = true;

	private ArrayList<Unit> party = date.PlayerParty.party;
	private ArrayList<Unit> guild = date.PlayerGuild.playerGuild;

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

	private void printGuild() {
		int count = 1;
		for (Unit i : guild) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", guild.size());
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
		if (party.size() == 4) {
			System.err.println("파티원 모집이 끝났습니다.");
			return;
		}

		if (guild.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}

		printGuild();
		try {
			System.out.print("파티 모집할 길드원 번호 입력 : ");
			buffer.setLength(0);
			String number = reader.readLine();
			inputParty(number);
		} catch (Exception e) {
		}

	}

	private void inputParty(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= guild.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		Unit unit = guild.get(num);
		for (Unit i : party) {
			if (i.equals(unit)) {
				System.err.println("이미 파티에 모집한 길드원입니다.");
				return;
			}
		}

		System.out.printf("%s\n를 파티모집 합니다.\n", unit);
		party.add(unit);
	}

	private void deport() {
		if (party.size() == 0) {
			System.err.println("파티원이 없습니다.");
			return;
		}
		printParty();
		try {
			System.out.print("추방할 파티원 번호 입력 : ");
			buffer.setLength(0);
			String number = reader.readLine();
			inputIndex(number);
		} catch (Exception e) {
		}
	}

	private void inputIndex(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= party.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		System.out.printf("%s\n 를 추방합니다.\n", party.get(num));
		party.remove(num);

	}
}
