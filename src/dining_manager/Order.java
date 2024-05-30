package dining_manager;

import java.util.HashMap;
import java.util.Map;

class Order {
	
	Map<String, Integer> plates;
	
	Order() {
		plates = new HashMap<>();
	}
	
	void add(String meal, int quantity) {
		plates.put(meal, quantity);
	}
	
	Map<String, Integer> getPlates() {
		return plates;
	}
	
	int getTotalAmount() {
		int total = 0;
		for (int quantity : plates.values()) {
			total += quantity;
		}
		return total;
	}
}