package text_rpg;

public class TextRPG {

	private void TextRPG() {
	}

	private static TextRPG instance = new TextRPG();

	public static TextRPG getInstance() {
		return instance;
	}
	
	public void run() {
		map.Map.mapThread.start();
	}
}
