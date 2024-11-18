package units;

import java.util.Random;

public class Unit {
	protected String name;
	protected int hp;
	protected int MAX_HP;
	protected int mp;
	protected int MAX_MP;
	protected int level;
	protected int MAX_EXP;
	protected int exp;
	protected int att;
	protected int def;

	public static Random ran = new Random();

	public Unit(String name, int hp, int mp, int att, int def) {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.MAX_MP = mp;
		this.mp = mp;
		this.level = 1;
		this.MAX_EXP = 10;
		this.exp = 0;
		this.att = att;
		this.def = def;
	}

	public Unit() {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.exp = 0;
	}

	public static String getName(String player) {
		String[] name1 = { "길동이", "둘리", "희동이", "짱구", "도라애몽", "노진구", "퉁퉁이", "훈이", "맹구", "철수", "유리", "비실이", "이슬이", "흰둥이",
				"검둥이", "누렁이" };
		int name1Size = ran.nextInt(name1.length);

		String name = name1[name1Size] + " " + player;
		return name;
	}

	public static int getAtt() {
		int att = ran.nextInt(15) + 1;
		return att;
	}

	public static int getDef() {
		int def = ran.nextInt(10) + 1;
		return def;
	}
}
