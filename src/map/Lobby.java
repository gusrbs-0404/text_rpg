package map;

public class Lobby extends Map implements Runnable {
	Lobby lobby = new Lobby();

	Thread lobbyThread = new Thread(lobby);

	public boolean isLobby = true;

	@Override
	public void run() {
		isLobby = true;
		while (isLobby) {
			try {
				System.out.println("=====[LOBBY]=====");
				System.out.println("[1. 전투] [2. 상점] [3. 길드] [4. 파티] [5. 인벤토리] [6. 종료]");
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
		case "전투":
			battle();
			isLobby = false;
			break;
		case "상점":
			store();
			isLobby = false;
			break;
		case "길드":
			guild();
			isLobby = false;
			break;
		case "파티":
			party();
			isLobby = false;
			break;
		case "인벤토리":
			inventory();
			isLobby = false;
			break;
		case "종료":
			System.out.println("RPG 게임 종료합니다.");
			isLobby = false;
			log = -1;
			break;
		default:
			System.err.println("메뉴 잘못 입력했습니다.");
			break;
		}
	}

	private void battle() {
		Battle battle = new Battle();
		Thread battleThread = new Thread(battle);

		battleThread.start();
	}

	private void store() {
		Store store = new Store();
		Thread storeThread = new Thread(store);

		storeThread.start();
	}

	private void guild() {
		Guild guild = new Guild();
		Thread guildThread = new Thread(guild);

		guildThread.start();
	}

	private void party() {
		Party party = new Party();
		Thread partyThread = new Thread(party);

		partyThread.start();
	}

	private void inventory() {
		Inventory inventory = new Inventory();
		Thread inventoryThread = new Thread(inventory);

		inventoryThread.start();
	}
}
