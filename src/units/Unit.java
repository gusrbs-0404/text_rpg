package units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import items.Item;
import items.ItemArmor;

public class Unit {
	public String name;
	public int hp;
	public int MAX_HP;
	public int mp;
	public int MAX_MP;
	public int level;
	public int MAX_EXP;
	public int exp;
	public int att;
	public int def;

	public static int upgradeHp;
	public static int upgradeMp;
	public static int upgradeAtt;
	public static int upgradeDef;
	public static int upgradeExp;

	// 아이템 장착여부
	public static HashMap<String, Item> equippedItems = new HashMap<>();
	
	private static ArrayList<Item> inventory = date.Inventory.inventory;
	private static ArrayList<Unit> party = date.PlayerParty.party;
	public static Random ran = new Random();

	// player
	public Unit(String name, int hp, int mp, int att, int def, int MAX_EXP) {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.MAX_MP = mp;
		this.mp = mp;
		this.level = 1;
		this.MAX_EXP = MAX_EXP;
		this.exp = 0;
		this.att = att;
		this.def = def;
	}

	// 몬스터
	public Unit(String name, int hp, int att, int def, int exp) {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.exp = exp;
	}

	// 파일로드
	public Unit(String name, int hp, int MAX_HP, int mp, int MAX_MP, int att, int def, int exp, int MAX_EXP,
			int level) {
		this.name = name;
		this.hp = hp;
		this.MAX_HP = hp;
		this.mp = mp;
		this.MAX_MP = mp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.MAX_EXP = MAX_EXP;
		this.level = level;
	}

	public static String newName(String player) {
		String[] name1 = { "길동이", "둘리", "희동이", "짱구", "도라애몽", "노진구", "퉁퉁이", "훈이", "맹구", "철수", "유리", "비실이", "이슬이", "흰둥이",
				"검둥이", "누렁이" };
		int name1Size = ran.nextInt(name1.length);

		String name = name1[name1Size] + " " + player;
		return name;
	}

	public static int newAtt() {
		int att = ran.nextInt(15) + 1;
		return att;
	}

	public static int newDef() {
		int def = ran.nextInt(10) + 1;
		return def;
	}

	public static int attack(Unit unit) {
		int attack = unit.att;
		return attack;
	}

	public static int critical() {
		int critical = ran.nextInt(10) + 1;
		return critical;
	}

	public static int skill(String skillName) {
		System.out.println(skillName + "스킬 발동!");
		int skill = ran.nextInt(10) + 1;
		return skill;
	}

	public static int exp(Unit unit) {
		int exp = unit.exp;
		return exp;
	}

	public static int monsterInteger() {
		int integer = 1;
		return integer;
	}

	// 아이템 장착
	public static void equipItem(Item items, int index) {
		for (Item item : inventory) {
			if (item.getName().equals(items.getName()) && item.isEquipable()) {
				equippedItems.put(items.getName(), item);
				party.get(index).att += item.getAttack();
				party.get(index).def += item.getDefense();
				inventory.remove(item);
				item.setEquipable(false);
				System.out.println(items.getName() + "이 장착되었습니다.");
				return;
			}
		}
		System.out.println("장착할 수 없는 아이템입니다.");
	}

	// 아이템 해제
	public static void unequipItem(Item items, int index) {
		if (equippedItems.containsKey(items.getName())) {
			Item item = equippedItems.get(items.getName());
			party.get(index).att -= item.getAttack();
			party.get(index).def -= item.getDefense();
			equippedItems.remove(items.getName());
			inventory.add(item);
			item.setEquipable(true);
			System.out.println(items.getName() + "이 해제되었습니다.");
			return;
		}
		System.out.println("장착된 아이템이 아닙니다.");
	}

	public static void showStats(int index) {
		System.out.println("공격력: " + party.get(index).att);
		System.out.println("방어력: " + party.get(index).def);
		// 장비장착여부
		for (String key : equippedItems.keySet()) {
			System.out.println("- " + key);
		}
	}

	@Override
	public String toString() {
		String msg = String.format("%s |[LV %d] | [체력 %d/%d] | [마나 %d/%d]\n\t[공격력 %d] | [방어력 %d] | [경험치 %d/%d] ", name,
				level, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP);
		return msg;
	}
}
