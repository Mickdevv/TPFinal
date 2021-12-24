package Pages_Objets;

public class DemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int result = show(1, 2);
		//showInt(result);
		
		String x = "Tuesday";
		switch(x) {
		
		case("Monday"):
			System.out.println("It's Monday");
			break;
			
		case("Tuesday"):
			System.out.println("It's Tuesday");
			break;
			
		case("Wednesday"):
			System.out.println("It's Wednesday");
			break;
		}
		
		
		
		if(x == "Monday")
		{
			System.out.println("It's Monday");
		}
		else if(x == "Tuesday")
		{
			System.out.println("It's Tuesday");
		}
		else if(x == "Wednesday")
		{
			System.out.println("It's Wednesday");
		}
		
		
		
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
