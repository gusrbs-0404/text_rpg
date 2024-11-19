package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import items.Item;
import units.Unit;

public class File {
	public ArrayList<String> ids = date.Member.ids;
	public ArrayList<String> pws = date.Member.pws;
	public ArrayList<Unit> playerGuild = date.PlayerGuild.playerGuild;
	public ArrayList<Unit> party = date.PlayerParty.party;
	public ArrayList<Item> inventory = date.Inventory.inventory;
	public int price = date.Price.getPrice();
	// 파티원 장비
	// 장착중인아이템
	public static FileWriter fileWriter;
	public static FileReader fileReader;
	public static BufferedReader bufferedReader;
	public static File file;

	public static String fileName = "RPG-GAME.txt";

}
