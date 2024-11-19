package date;

public class Price {
	static int Price = 500000;

	public static int getPrice() {
		return Price;
	}

	public static void minusPrice(int price) {
		Price -= price;
	}
	
	public static void plusPrice(int price) {
		Price += price;
	}
}
