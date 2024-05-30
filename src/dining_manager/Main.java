package dining_manager;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
	static Logger logger = Logger.getLogger("Main");;
	public static void main(String[] args) {
		Menu menu = new Menu();
		Order order = new Order();
		SumTheTotal calculator = new SumTheTotal();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				menu.show();
				logger.info("Enter meal name to order or 'done' to finish: ");
				String input = scanner.nextLine();
				if (input.equals("done")) { 
					break;
				}
				else if(!menu.aval(input)) {
				logger.info("meal not available. Please re-select.");
				continue;
				}
				logger.info("Enter quantity for " + input + ": ");
				int quantity = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				if (quantity <= 0) {
				System.out.println("Invalid quantity. Please re-enter.");
				continue;
				}
				order.add(input, quantity);
			}
			
			double totalC_ = calculator.calculateTotalCost(order, menu);
			int var2 = order.getTotalAmount();
			
			if (var2 > 100) {
				System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
				return;
			}
			
			System.out.println("Your Ord:");
			
			for (Map.Entry<String, Integer> item : order.getPlates().entrySet()) {
				System.out.println(item.getKey() + ": " + item.getValue());
			}
			
			System.out.println("Total Cost: $" + totalC_);
			System.out.print("Confirm order (yes/no): ");
			String confirm = scanner.nextLine();
			
			if (!confirm.equals("yes") || !confirm.equals("YES")) {
				System.out.println("Order canceled.");
				System.out.println(-1);
				return;
			}
			
			System.out.println("Order confirmed. Total cost is: $" + totalC_);
		}
	}
}