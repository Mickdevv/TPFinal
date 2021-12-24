package Pages_Objets;

public class DemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = show(1, 2);
		showInt(result);
		
	}
	
	static void showText(String text, int integer) {
		System.out.println(text + integer);
	}
	
	static void showInt(int text) {
		System.out.println(text);
	}
	
	static void show() {
		System.out.println("No Arguments");
	}
	
	static int show(int x, int y) {
		return x + y;
	}

}
