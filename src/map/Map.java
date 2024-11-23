package map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

import units.Unit;

public class Map implements Runnable {
	// 문자열 입력 - 임시정장
	public StringBuffer buffer = new StringBuffer();
	// 문자열 출력 = print랑 비슷
	public BufferedWriter wirter = new BufferedWriter(new OutputStreamWriter(System.out));
	// 입력 받기
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static Map map = new Map();

	public static Thread mapThread = new Thread(map);

	public static Random ran = new Random();

	boolean isMap = true;

	public int log = -1;

	public static ArrayList<String> ids = date.Member.ids;
	public static ArrayList<String> pws = date.Member.pws;

	@Override
	public void run() {
		isMap = true;
		while (isMap) {
			try {
				input("=====[RPG-GAME]=====");
				input("[1. 회원가입] [2. 로그인] [3. 로그아웃] [4. 회원탈퇴]\n[5. 게임시작] [6. 파일저장] [7. 파일로드] [8. 종료]");
				input("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {

		if (log == -1 && ids.size() == 0
				&& !(select.equals("회원가입") || select.equals("종료") || select.equals("파일저장") || select.equals("파일로드"))) {
			input("회원가입부터 진행해주세요.");
			return;
		}

		if (log == -1 && (select.equals("로그인아웃") || select.equals("회원탈퇴") || select.equals("게임시작"))) {
			input("로그인후 이용가능합니다.");
			return;
		}

		if (log != -1 && (select.equals("회원가입") || select.equals("로그인"))) {
			input("이미 로그인 중입니다.");
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
			input("[RPG 게임 종료합니다.]");
			isMap = false;
			break;
		case "파일저장":
			input("[파일 저장합니다.]");
			file.File.saveData();
			break;
		case "파일로드":
			input("[파일 로드합니다.]");
			file.File.loadData();
			break;
		default:
			input("메뉴 잘못 입력했습니다.");
			break;
		}

	}

	private void memberIn() {
		try {
			input("회원가입을 시작합니다.");
			input("아이디 입력 :");
			String id = reader.readLine();

			boolean idck = false;
			for (int i = 0; i < ids.size(); i++) {
				if (ids.get(i).equals(id)) {
					idck = true;
				}
			}

			if (idck) {
				input("중복된 아이디 입니다.");
				return;
			}

			input("비밀번호 입력 :");
			String pw = reader.readLine();

			ids.add(id);
			pws.add(pw);

			input("회원가입 완료!");
		} catch (Exception e) {
		}
	}

	private void logIn() {
		try {
			input("로그인 진행 합니다.");
			input("아이디 입력 :");
			String id = reader.readLine();

			input("비밀번호 입력 :");
			String pw = reader.readLine();

			boolean login = false;
			for (int i = 0; i < date.Member.ids.size(); i++) {
				if (ids.get(i).equals(id) && pws.get(i).equals(pw)) {
					login = true;
					log = i;
				}
			}

			if (!login) {
				input("아이디 또는 비밀번호 잘못입력했습니다.");
			}

			input(ids.get(log) + " 회원님, 로그인 했습니다.");
		} catch (Exception e) {
		}
	}

	private void gameStart() {
		System.out.println("[RPG-GAME 을 시작합니다.]");

		Lobby lobby = new Lobby();

		Thread lobbyThread = new Thread(lobby);

		lobbyThread.start();

		isMap = false;
	}

	private void logOut() {
		input(ids.get(log) + " 회원님, 로그어윳 했습니다.");
		log = -1;
	}

	private void memberOut() {
		try {
			input("회원 탈퇴 진행합니다.");

			input("비밀번호 입력 :");
			String pw = reader.readLine();

			boolean pwck = false;
			for (int i = 0; i < pws.size(); i++) {
				if (log == i && pws.get(i).equals(pw)) {
					pwck = true;
				}
			}

			if (!pwck) {
				input("비밀번호를 잘못입력했습니다.");
				return;
			}

			input(ids.get(log) + " 회원님, 회원탈퇴 했습니다.\n");
			ids.remove(log);
			pws.remove(log);
			log = -1;

		} catch (Exception e) {
		}
	}

	public void input(Object object) {
		try {
			wirter.append(object + "\n");
			wirter.flush();
		} catch (Exception e) {
		}
	}
}
