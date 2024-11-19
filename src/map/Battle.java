package map;

import java.util.ArrayList;

import date.Inventory;
import items.ItemMonsterInteger;
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
				input("=====[BATTLE]=====");
				input("[1. 좀비] [2. 오크] [3. 드래곤] [4. 종료]");
				input("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {

			}
		}
	}

	private void menu(String select) {
		printParty();
		// 예외처리 - 파티 4명 다 모였을때 입장가능
		if (party.size() < 4 && !select.equals("종료")) {
			input("충분한 파티원을 모집하고 전투하세요!");
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
			try {
				input("전투 종료합니다.");
				Thread lobbyThread = new Thread(Lobby.lobby);
				isBattle = false;
				lobbyThread.start();
			} catch (Exception e) {
			}
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
		int playerCount = battleParty();

		if (playerCount == 0) {
			input("전투할 플레이가 없다..");
			return;
		}

		while (isBattle) {
			printPartyHp();
			int action = action();
			int playreIndex = actionplayerIndex();

			int damage = 0;
			switch (action) {
			case 0:
				damage = party.get(playreIndex).att;
				input(party.get(playreIndex).name + " 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = party.get(playreIndex).att + party.get(playreIndex).att / 2;
				input(party.get(playreIndex).name + " 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = party.get(playreIndex).att * 2;
				if (party.get(playreIndex).mp >= 10) {
					party.get(playreIndex).mp -= 10;
					input(party.get(playreIndex).name + " 스킬 공격! 데미지: " + damage);
				} else {
					input(party.get(playreIndex).name + " 마나가 없어서 스킬 공격을 못했다....");
				}
				break;
			default:
				damage = 0;
				break;
			}

			monster.hp -= damage;

			if (!isHpUnit(monster)) {
				input(monster.name + "의 남은 체력 : " + monster.hp);
				input("플레이어 승리!");
				exp(monster);
				if (ranMonsterInteger() == units.Unit.monsterInteger()) {
					ItemMonsterInteger monsterInteger = new ItemMonsterInteger("몬스터 정수", 1000);
					Inventory.add(monsterInteger);
					input("몬스터 정수를 얻었다!");
				}
				isBattle = false;
				return;
			}

			input(monster.name + "의 남은 체력 : " + monster.hp);

			action = action();
			damage = 0;

			switch (action) {
			case 0:
				damage = monster.att;
				input(monster.name + " 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = zombie.att / 2;
				input(monster.name + " 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = zombie.att * 2;
				input(monster.name + " 스킬 공격! 데미지: " + damage);
				break;
			default:
				damage = 0;
				break;
			}
			date.PlayerParty.party.get(playreIndex).hp -= damage;

			if (!isHpUnit(party.get(playreIndex))) {
				playerCount--;
				input(party.get(playreIndex).name + "이 죽었다..");
			}

			input(party.get(playreIndex).name + "의 남은 체력 : " + party.get(playreIndex).hp);

			if (playerCount == 0) {
				input("플레이어가 모두 죽었다! 몬스터 승리!");
				isBattle = false;
				return;
			}

			try {
				Thread.sleep(700);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void exp(Unit monster) {
		input(monster.exp + "EXP를 얻었다!!");
		for (Unit i : party) {
			i.exp += monster.exp;
			if (i.exp >= i.MAX_EXP) {
				i.exp = i.MAX_EXP - i.exp;
				i.level++;
				i.MAX_EXP += 5;
				i.att += 5;
				i.def += 5;
				i.hp += 30;
				input(i.name + " 레벨업!!!");
			}
		}
	}

	private int battleParty() {
		int count = 0;
		for (Unit i : party) {
			if (i.hp != 0) {
				count++;
			}
		}
		return count;
	}

	private void printParty() {
		int count = 1;
		for (Unit i : party) {
			input(count++ + "번 | " + i);
		}
		input("총인원 수 : " + party.size());
	}

	private void printPartyHp() {
		for (Unit i : party) {
			input(i.name + " | " + i.hp);
		}
	}

	private int action() {
		int action = ran.nextInt(3);
		// 0 공격 1 치명타 2 스킬
		return action;
	}

	private int actionplayerIndex() {
		while (true) {
			int playerIndex = ran.nextInt(4);

			if (date.PlayerParty.party.get(playerIndex).hp != 0) {
				return playerIndex;
			}
		}
	}

	private boolean isHpUnit(Unit unit) {
		if (unit.hp < 0) {
			unit.hp = 0;
			return false;
		}
		return true;
	}

	private int ranMonsterInteger() {
		int rnaNum = ran.nextInt(2);
		return rnaNum;
	}
}
