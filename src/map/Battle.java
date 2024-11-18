package map;

import java.util.ArrayList;

import monster.Zombie;
import units.Unit;

public class Battle extends Map implements Runnable {

	private monster.Zombie zombie;
	private monster.Oak oak;
	private monster.Dragon dragon;
	private ArrayList<Unit> party = date.PlayerParty.party;

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
		if (party.size() < 4) {
			System.err.println("충분한 파티원을 모집하고 전투하세요!");
			return;
		}

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
	}

	private void zombie() {
		zombie = new monster.Zombie();
		battlePlay(zombie);
	}

	private void oak() {
		oak = new monster.Oak();
		battlePlay(oak);
	}

	private void dragon() {
		dragon = new monster.Dragon();
		battlePlay(dragon);
	}

	private void battlePlay(Unit monster) {
		boolean isBattle = true;
		while (isBattle) {
			int action = action();
			int playreIndex = actionplayerIndex();

			int damage;
			switch (action) {
			case 0:
				damage = party.get(playreIndex).att;
				System.out.println(party.get(playreIndex).name + "이(가) 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = party.get(playreIndex).att + party.get(playreIndex).att / 2;
				System.out.println(party.get(playreIndex).name + "이(가) 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = party.get(playreIndex).att * 2; 
				System.out.println(party.get(playreIndex).name + "이(가) 스킬 공격! 데미지: " + damage);
				break;
			default:
				damage = 0;
				break;
			}
		}

		System.out.println("남은 몬스터의 체력 : " + monster.hp);

		if (!isHpMonster(monster)) {
			System.out.println("플레이어 승리!");

			if (ranMonsterInteger() == units.Unit.monsterInteger()) {
				System.out.println("몬스터 정수를 얻었다!");
//				Item monsterInteger = new Item("몬스터 정수", 1000);
//				RPGGame.inventory.add(monsterInteger);
			}
			isBattle = false;
			return;
		}
	}

	private int action() {
		int action = ran.nextInt(3);
		// 0 공격 1 치명타 2 스킬
		return action;
	}

	private int actionplayerIndex() {
		int playerIndex = ran.nextInt(4);
		return playerIndex;
	}

	private boolean isHpMonster(Unit monster) {
		if (monster.hp < 0) {
			monster.hp = 0;
			return false;
		}
		return true;
	}

	private int ranMonsterInteger() {
		int rnaNum = ran.nextInt() + 3;
		return rnaNum;
	}
}
