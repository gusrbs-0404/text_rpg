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
	int price = date.Price.getPrice();
	// 파티원 장비
	// 장착중인아이템
	public FileWriter fileWriter;
	public FileReader fileReader;
	public BufferedReader bufferedReader;
	public File file;

	public String fileName = "RPG-GAME.txt";

}
