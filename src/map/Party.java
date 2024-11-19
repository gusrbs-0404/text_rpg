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
				input("=====[PARTY]=====");
				input("[1. 조회] [2. 영입] [3. 추방] [4. 종료]");
				input("메뉴 입력 : ");
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
			input("파티메뉴를 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isParty = false;
			lobbyThread.start();
			break;
		default:
			input("메뉴 잘못 입력했습니다.");
			break;
		}
	}

	private void inquiry() {
		if (party.size() == 0) {
			input("파티원이 없습니다.");
			return;
		}
		printParty();
	}

	private void printGuild() {
		int count = 1;
		for (Unit i : guild) {
			input(count++ + "번 | ");
			input(i);
		}
		input("총인원 수 : " + guild.size());
	}

	private void printParty() {
		int count = 1;
		for (Unit i : party) {
			input(count++ + "번 | ");
			input(i);
		}
		input("총인원 수 : " + party.size());
	}

	private void recruit() {
		if (party.size() == 4) {
			input("파티원 모집이 끝났습니다.");
			return;
		}

		if (guild.size() == 0) {
			input("길드원이 없습니다.");
			return;
		}

		printGuild();
		try {
			input("파티 모집할 길드원 번호 입력 : ");
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
				input("잘못입력했습니다.");
			}
		} catch (Exception e) {
			input("잘못입력했습니다.");
			return;
		}

		Unit unit = guild.get(num);
		for (Unit i : party) {
			if (i.equals(unit)) {
				input("이미 파티에 모집한 길드원입니다.");
				return;
			}
		}

		input(unit + " 를 파티모집 합니다.");
		party.add(unit);
	}

	private void deport() {
		if (party.size() == 0) {
			input("파티원이 없습니다.");
			return;
		}
		printParty();
		try {
			input("추방할 파티원 번호 입력 : ");
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
				input("잘못입력했습니다.");
			}
		} catch (Exception e) {
			input("잘못입력했습니다.");
			return;
		}

		input(party.get(num) + "를 추방합니다.\n");
		party.remove(num);

	}
}
