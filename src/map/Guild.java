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
		if (guild.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}
		printGuild();
	}

	private void printGuild() {
		int count = 1;
		for (Unit i : guild) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", guild.size());
	}

	private void recruit() {
		if (guild.size() == 10) {
			System.err.println("최대인원 입니다!");
			return;
		}

		int ranNum = ran.nextInt(3) + 1;
		switch (ranNum) {
		case 1: {
			players.Archer archer = new players.Archer();
			guild.add(archer);
			System.out.println("궁수 영입완료!");
			break;
		}
		case 2: {
			players.Warrior warrior = new players.Warrior();
			guild.add(warrior);
			System.out.println("전사 영입완료!");
			break;
		}
		case 3: {
			players.Wizard wizard = new players.Wizard();
			guild.add(wizard);
			System.out.println("마법사 영입완료!");
			break;
		}
		}
	}

	private void deport() {
		if (guild.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}

		printGuild();

		try {
			System.out.print("추방할 길드원 번호 입력 : ");
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
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		System.out.printf("%s\n를 추방합니다.\n", guild.get(num));
		guild.remove(num);
	}

}
