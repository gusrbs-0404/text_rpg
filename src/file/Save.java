package file;

import java.io.FileWriter;

public class Save extends File {

	public void save(String date) {
		fileWriter = null;

		String txt = date();
	}

	private String date() {
		String date = "";
		// 회원 사이즈
		// 회원 아이디
		// 회원 비번
		// 길드
		// 길드 사이즈
		// 길드원 name, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP, level
		// 파티 사이즈
		// 파티 name, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP, level
		// 인벤토리
		// 인벤토리 사이즈
		// 아이템 name, att, def, price
		// 돈
		// 파티원 장비
		// 장착중인 아이템

		// 회원사이즈
		date += ids.size() + "\n";
		// 아이디
		for (int i = 0; i < ids.size(); i++) {
			date += ids.get(i);
			if (i < ids.size() - 1) {
				date += "/";
			}
		}
		date += "\n";
		// 비번
		for (int i = 0; i < pws.size(); i++) {
			date += pws.get(i);
			if (i < pws.size() - 1) {
				date += "/";
			}
		}
		date += "\n";
		// 길드 사이즈
		date += playerGuild.size() + "\n";

		// 길드원
		// name, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP, level
		for (int i = 0; i < playerGuild.size(); i++) {
			date += playerGuild.get(i).name + ",";
			date += playerGuild.get(i).hp + ",";
			date += playerGuild.get(i).MAX_HP + ",";
			date += playerGuild.get(i).mp + ",";
			date += playerGuild.get(i).MAX_MP + ",";
			date += playerGuild.get(i).att + ",";
			date += playerGuild.get(i).def + ",";
			date += playerGuild.get(i).exp + ",";
			date += playerGuild.get(i).MAX_EXP + ",";
			date += playerGuild.get(i).level;

			if (i < pws.size() - 1) {
				date += "/";
			}
		}

		date += "\n";
		// 파티 사이즈
		date += party.size() + "\n";

		// 파티원
		// name, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP, level
		for (int i = 0; i < party.size(); i++) {
			date += party.get(i).name + ",";
			date += party.get(i).hp + ",";
			date += party.get(i).MAX_HP + ",";
			date += party.get(i).mp + ",";
			date += party.get(i).MAX_MP + ",";
			date += party.get(i).att + ",";
			date += party.get(i).def + ",";
			date += party.get(i).exp + ",";
			date += party.get(i).MAX_EXP + ",";
			date += party.get(i).level;

			if (i < pws.size() - 1) {
				date += "/";
			}
		}

		date += "\n";
		// 인벤토리 사이즈
		date += inventory.size() + "\n";
		// 아이템
		// name, att, def, price
		for (int i = 0; i < inventory.size(); i++) {
			date += inventory.get(i).name + ",";
			date += inventory.get(i).attack + ",";
			date += inventory.get(i).defense + ",";
			date += inventory.get(i).price;

			if (i < pws.size() - 1) {
				date += "/";
			}
		}

		date += "\n";
		// 돈
		date += price + "\n";

		// 파티원 장비
		// 장착중인 아이템

		return date;
	}
}
