package dining_manager;

import java.util.Map;

class SumTheTotal {
	
	double baseCost = 5;
	
	double calculateTotalCost(Order order, Menu menu) {
		double totalCost = baseCost;
		int quantity = 0;
		for (Map.Entry<String, Integer> item : order.getPlates().entrySet()) {
			totalCost += menu.getPrice(item.getKey()) * item.getValue();
		quantity += item.getValue();
		}
		double discount = 0;
		if (quantity > 5) {
		discount = 0.1;
		} else if (quantity > 10) {
		discount = 0.2;
		}
		totalCost = totalCost - (totalCost * discount);
		//TODO: Add more discounts based on total cost in requirements
		return totalCost;
	}
}