package date;

public class Price {
	static int price = 500000;

	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		Price.price = price;
	}

	public static void minusPrice(int price) {
		price -= price;
	}
	
	public static void plusPrice(int price) {
		price += price;
	}
}
