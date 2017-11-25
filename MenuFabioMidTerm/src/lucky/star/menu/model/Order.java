package lucky.star.menu.model;

import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> orderedItems;

	public Order() {
		orderedItems = new ArrayList<MenuItem>();
	}

	public ArrayList<MenuItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(ArrayList<MenuItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public void addItem(MenuItem mi) {
		orderedItems.add(mi);
	}
}