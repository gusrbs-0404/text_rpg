package units;

import java.util.Random;

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

	public static String newName(String player) {
		String[] name1 = { "길동이", "둘리", "희동이", "짱구", "도라애몽", "노진구", "퉁퉁이", "훈이", "맹구", "철수", "유리", "비실이", "이슬이", "흰둥이",
				"검둥이", "누렁이" };
		int name1Size = ran.nextInt(name1.length);

		String name = name1[name1Size] + " " + player;
		return name;
	}

//	public static String getName() {
//		return name;
//	}

	public static int newAtt() {
		int att = ran.nextInt(15) + 1;
		return att;
	}

	public static int newDef() {
		int def = ran.nextInt(10) + 1;
		return def;
	}

	public int attack(Unit unit) {
		int attack = unit.att;
		return attack;
	}

	public int critical() {
		int critical = ran.nextInt(10) + 1;
		return critical;
	}

	public int skill(String skillName) {
		System.out.println(skillName + "스킬 발동!");
		int skill = ran.nextInt(10) + 1;
		return skill;
	}

	public int exp(Unit unit) {
		int exp = unit.exp;
		return exp;
	}

	@Override
	public String toString() {
		String msg = String.format("%s |[LV %d] | [체력 %d/%d] | [마나 %d/%d]\n\t[공격력 %d] | [방어력 %d] | [경험치 %d/%d] ", name,
				level, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP);
		return msg;
	}
}
