import java.util.ArrayList;
import java.util.Scanner;

public class HandleCandles {

	ArrayList<Candle> list;
	
	public HandleCandles() {
		list = new ArrayList<Candle>();		
	}
	
	public void displayMenu() {
		System.out.print("\n\tMENU\n1: Add candle\n2: Remove candle\n3: Light candle\n4: Extinguish candle\n"
				+ "5: Display candles\n9: Exit program\n");		
	}
	
	public void processChoice(int selection) {
		switch (selection) {
		case 1:
			addCandle();
			break;
		case 2:
			removeCandle();
			break;
		case 3: 
			lightCandle(true);
			break;
		case 4: 
			lightCandle(false);
			break;
		case 5: 
			displayCandles();
			break;
		case 9: 
			System.out.println("\nThank you for using the program. Goodbye!");
			break;
		default: 
			System.out.println("Invalid choice.");
			break;
		}
	}
	
	private void displayCandles() {
		if (list.size() == 0) {
			System.out.println("There are no candles to display.");
		} else {
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
				Candle candle = list.get(i);
				System.out.println(candle.toString());
			}
		}
	}
	
	private void lightCandle(boolean light) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("What is the height of the candle you want to light/extinguish? ");
		int height = scanner.nextInt();
		System.out.print("What is the color of the candle you want to light/extinguish? ");
		String color = scanner.next();
		
		int size = list.size();
		System.out.println();
		for (int i = 0; i < size; i++) {
			Candle candle = list.get(i);
			if ((candle.height == height) && (candle.color.equalsIgnoreCase(color))) {
				if (light) {
					candle.isLit = true;
				} else {
					candle.isLit = false;
				}
				list.set(i,  candle);
				System.out.println("\nLit/extinguished candle: " + candle.toString());
				
				return;
			}
		}
		System.out.println("\nThere is no candle of that height and color.");
	}
	
	private void removeCandle() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("What is the height of the candle you want to remove? ");
		int height = scanner.nextInt();
		System.out.print("What is the color of the candle you want to remove? ");
		String color = scanner.next();
		
		int size = list.size();
		System.out.println();
		for (int i = 0; i < size; i++) {
			Candle candle = list.get(i);
			if ((candle.height == height) && (candle.color.equalsIgnoreCase(color))) {
				list.remove(i);
				System.out.println("\nRemoved the following candle: " + candle.toString());
				return;
			}
		}
		System.out.println("\nThere is no candle of that height and color.");
	}
	
	private void addCandle() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nWhat is the candle's color? ");
		String color = scanner.nextLine();
		
		System.out.print("\nWhat is the candle's height? ");
		int height = scanner.nextInt();
		
		System.out.print("\nWhat is the candle's diameter? ");
		float diameter = scanner.nextFloat();
		
		Candle candle = new Candle(color, height, diameter);
		
		System.out.println("\nThe following candle was created: " + candle.toString());
		
		list.add(candle);
	}
	
	public static void main(String[] args) {
		
		HandleCandles handler = new HandleCandles();
		
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		
		do {

			handler.displayMenu();
			
			System.out.print("\nEnter your selection: ");
			selection = scanner.nextInt();
			
			handler.processChoice(selection);
		} while (selection != 9);
		
		scanner.close();
	}

}
