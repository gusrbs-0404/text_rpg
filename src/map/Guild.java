package map;

import java.util.ArrayList;

import units.Unit;

public class Guild extends Map implements Runnable {

	private boolean isGuild = true;

	private ArrayList<Unit> guild = date.PlayerGuild.playerGuild;

	@Override
	public void run() {
		while (isGuild) {
			try {
				input("=====[GUILD]=====");
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
			input("길드메뉴룰 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isGuild = false;
			lobbyThread.start();
			break;
		}
	}

	private void inquiry() {
		if (guild.size() == 0) {
			input("길드원이 없습니다.");
			return;
		}
		printGuild();
	}

	private void printGuild() {
		int count = 1;
		for (Unit i : guild) {
			input(count++ + "번 | ");
			input(i);
		}
		input("총인원 수 : " + guild.size());
	}

	private void recruit() {
		if (guild.size() == 10) {
			input("최대인원 입니다!");
			return;
		}

		int ranNum = ran.nextInt(3) + 1;
		switch (ranNum) {
		case 1: {
			players.Archer archer = new players.Archer();
			guild.add(archer);
			input("궁수 영입완료!");
			break;
		}
		case 2: {
			players.Warrior warrior = new players.Warrior();
			guild.add(warrior);
			input("전사 영입완료!");
			break;
		}
		case 3: {
			players.Wizard wizard = new players.Wizard();
			guild.add(wizard);
			input("마법사 영입완료!");
			break;
		}
		}
	}

	private void deport() {
		if (guild.size() == 0) {
			input("길드원이 없습니다.");
			return;
		}

		printGuild();

		try {
			input("추방할 길드원 번호 입력 : ");
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
			if (num < 0 || num >= guild.size()) {
				input("잘못입력했습니다.");
			}
		} catch (Exception e) {
			input("잘못입력했습니다.");
			return;
		}

		input(guild.get(num) + "\n를 추방합니다.");
		guild.remove(num);
	}

}
