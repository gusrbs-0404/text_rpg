package map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Map implements Runnable {
	// 문자열 입력 - 임시정장
	public StringBuffer buffer = new StringBuffer();
	// 문자열 출력 = print랑 비슷
	public BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));
	// 입력 받기
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static Map map = new Map();

	public static Thread mapThread = new Thread(map);

	boolean isMap = true;

	public int log = -1;

	@Override
	public void run() {
		isMap = true;
		while (isMap) {
			try {
				System.out.println("=====[RPG-GAME]=====");
				System.out.println("[1. 회원가입] [2. 로그인] [3. 로그아웃] [4. 회원탈퇴] [5. 게임시작] [6. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {

			}
		}

	}

	private void menu(String select) {
		if (log == -1 && date.Member.ids.size() == 0 && !select.equals("회원가입")) {
			System.err.println("회원가입부터 진행해주세요.");
			return;
		}

		if (log == -1 && (select.equals("로그인아웃") || select.equals("회원탈퇴") || select.equals("게임시작"))) {
			System.err.println("로그인후 이용가능합니다.");
			return;
		}

		if (log != -1 && (select.equals("회원가입") || select.equals("로그인"))) {
			System.err.println("이미 로그인 중입니다.");
			return;
		}

		switch (select) {
		case "회원가입":
			memberIn();
			break;
		case "로그인":
			logIn();
			break;
		case "로그아웃":
			logOut();
			break;
		case "회원탈퇴":
			memberOut();
			break;
		case "게임시작":
			gameStart();
			break;
		case "종료":
			System.out.println("RPG 게임 종료합니다.");
			break;
		default:
			System.err.println("메뉴 잘못 입력했습니다.");
			break;
		}

	}

	private void memberIn() {
		try {
			System.out.println("회원가입을 시작합니다.");
			System.out.println("아이디 입력 :");
			String id = reader.readLine();

			boolean idck = false;
			for (int i = 0; i < date.Member.ids.size(); i++) {
				if (date.Member.ids.get(i).equals(id)) {
					idck = true;
				}
			}

			if (idck) {
				System.err.println("중복된 아이디 입니다.");
				return;
			}

			System.out.println("비밀번호 입력 :");
			String pw = reader.readLine();

			date.Member.ids.add(id);
			date.Member.pws.add(pw);

			System.out.println("회원가입 완료!");
		} catch (Exception e) {
		}

	}

	private void logIn() {
		try {
			System.out.println("로그인 진행 합니다.");
			System.out.print("아이디 입력 :");
			String id = reader.readLine();

			System.out.println("비밀번호 입력 :");
			String pw = reader.readLine();

			boolean login = false;
			for (int i = 0; i < date.Member.ids.size(); i++) {
				if (date.Member.ids.get(i).equals(id) && date.Member.pws.get(i).equals(pw)) {
					login = true;
					log = i;
				}
			}

			if (!login) {
				System.err.println("아이디 또는 비밀번호 잘못입력했습니다.");
			}

			System.out.printf("%s 회원님, 로그인 했습니다.\n", date.Member.ids.get(log));
		} catch (Exception e) {
		}
	}

	private void gameStart() {
		System.out.println("RPG-GAME 을 시작합니다.");

		Lobby lobby = new Lobby();

		Thread lobbyThread = new Thread(lobby);

		lobbyThread.start();

		isMap = false;
	}

	private void logOut() {
		System.out.printf("%s 회원님, 로그어윳 했습니다.\n", date.Member.ids.get(log));
		log = -1;
	}

	private void memberOut() {
		try {
			System.out.println("회원 탈퇴 진행합니다.");

			System.out.println("비밀번호 입력 :");
			String pw = reader.readLine();

			boolean pwck = false;
			for (int i = 0; i < date.Member.pws.size(); i++) {
				if (log == i && date.Member.pws.get(i).equals(pw)) {
					pwck = true;
				}
			}

			if (!pwck) {
				System.err.println("비밀번호를 잘못입력했습니다.");
				return;
			}

			System.out.printf("%s 회원님, 회원탈퇴 했습니다.\n", date.Member.ids.get(log));
			date.Member.ids.remove(log);
			date.Member.pws.remove(log);
			log = -1;

		} catch (Exception e) {
		}
	}
}
