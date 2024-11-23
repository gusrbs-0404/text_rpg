package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import items.Item;
import units.Unit;

public class File {
	public static ArrayList<String> ids = date.Member.ids;
	public static ArrayList<String> pws = date.Member.pws;
	public static ArrayList<Unit> playerGuild = date.PlayerGuild.playerGuild;
	public static ArrayList<Unit> party = date.PlayerParty.party;
	public static ArrayList<Item> inventory = date.Inventory.inventory;
	public static int price = date.Price.getPrice();
	// 파티원 장비
	// 장착중인아이템
	public static FileWriter fileWriter;
	public static FileReader fileReader;
	public static BufferedReader bufferedReader;
	public static File file;

	public static String fileName = "RPG-GAME.txt";

	public static void saveData() {
		try {
			fileWriter = new FileWriter(fileName);

			// 아이디
			for (int i = 0; i < ids.size(); i++) {
				fileWriter.write(ids.get(i));
				if (i < ids.size() - 1) {
					fileWriter.write("/");
				}
			}
			fileWriter.write("\n");

			// 비밀번호
			for (int i = 0; i < pws.size(); i++) {
				fileWriter.write(pws.get(i));
				if (i < pws.size() - 1) {
					fileWriter.write("/");
				}
			}
			fileWriter.write("\n");

			// 길드 사이즈
			fileWriter.write(playerGuild.size() + "\n");

			// 길드원
			for (Unit unit : playerGuild) {
				fileWriter.write(unit.name + "," + unit.hp + "," + unit.MAX_HP + "," + unit.mp + "," + unit.MAX_MP + ","
						+ unit.att + "," + unit.def + "," + unit.exp + "," + unit.MAX_EXP + "," + unit.level + "\n");
			}

			// 파티 사이즈
			fileWriter.write(party.size() + "\n");

			// 파티원
			for (Unit unit : party) {
				fileWriter.write(unit.name + "," + unit.hp + "," + unit.MAX_HP + "," + unit.mp + "," + unit.MAX_MP + ","
						+ unit.att + "," + unit.def + "," + unit.exp + "," + unit.MAX_EXP + "," + unit.level + "\n");
			}

			// 인벤토리 사이즈
			fileWriter.write(inventory.size() + "\n");

			// 아이템
			for (Item item : inventory) {
				fileWriter.write(item.name + "," + item.attack + "," + item.defense + "," + item.price + "\n");
			}

			// 돈
			fileWriter.write(price + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("파일을 닫는 중 오류 발생: " + e.getMessage());
			}
		}
	}

	public static void loadData() {

		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);

			// 아이디
			ids = new ArrayList<>();
			String[] idArray = bufferedReader.readLine().split("/");
			for (String id : idArray) {
				ids.add(id);
				System.out.println(ids);
			}

			// 비밀번호
			pws = new ArrayList<>();
			String[] pwArray = bufferedReader.readLine().split("/");
			for (String pw : pwArray) {
				pws.add(pw);
			}

			// 길드 사이즈
			int guildSize = Integer.parseInt(bufferedReader.readLine());

			// 길드원
			playerGuild = new ArrayList<>();
			for (int i = 0; i < guildSize; i++) {
				String[] guildData = bufferedReader.readLine().split(",");
				Unit unit = new Unit(guildData[0], Integer.parseInt(guildData[1]), Integer.parseInt(guildData[2]),
						Integer.parseInt(guildData[3]), Integer.parseInt(guildData[4]), Integer.parseInt(guildData[5]),
						Integer.parseInt(guildData[6]), Integer.parseInt(guildData[7]), Integer.parseInt(guildData[8]),
						Integer.parseInt(guildData[9]));
				playerGuild.add(unit);
			}

			// 파티 사이즈
			int partySize = Integer.parseInt(bufferedReader.readLine());

			// 길드원
			party = new ArrayList<>();
			for (int i = 0; i < partySize; i++) {
				String[] partyData = bufferedReader.readLine().split(",");
				Unit unit = new Unit(partyData[0], Integer.parseInt(partyData[1]), Integer.parseInt(partyData[2]),
						Integer.parseInt(partyData[3]), Integer.parseInt(partyData[4]), Integer.parseInt(partyData[5]),
						Integer.parseInt(partyData[6]), Integer.parseInt(partyData[7]), Integer.parseInt(partyData[8]),
						Integer.parseInt(partyData[9]));
				party.add(unit);
			}

			// 인벤토리 사이즈
			int inventorySize = Integer.parseInt(bufferedReader.readLine());
			inventory = new ArrayList<>();
			for (int i = 0; i < inventorySize; i++) {
				String[] itemData = bufferedReader.readLine().split(",");
				Item item = new Item(itemData[0], Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2]),
						Integer.parseInt(itemData[3]));
				inventory.add(item);
			}

			// 돈
			price = Integer.parseInt(bufferedReader.readLine());

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();

			} catch (IOException e) {
				System.out.println("파일을 닫는 중 오류 발생: " + e.getMessage());
			}
		}
	}

}
