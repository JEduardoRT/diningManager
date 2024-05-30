package dining_manager;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
class Menu {
	
	Map<String, Double> items;
	Logger logger;
	
	Menu() {
		logger = Logger.getLogger(getClass().getName());
		items = new HashMap<>();
		items.put("Burger", 10.0);
		items.put("Pizza", 15.0);
		items.put("Salad", 8.0);
		items.put("Pasta", 12.0);
	}
	
	void show() {
		logger.info("Menu:\n");
		for (Map.Entry<String, Double> item : items.entrySet()) {
			logger.info(item.getKey() + ": $" + item.getValue() + "\n");
		}
	}
	
	boolean aval(String meal) {
		return meal.equals("Burger") || meal.equals("Pizza") || meal.equals("Salad") || meal.equals("Pasta");
	}
	
	double getPrice(String meal) {
		return items.get(meal);
	}
}

