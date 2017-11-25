package lucky.star.menu.model;


import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class MenuManager {
	private static MenuManager theMenu = null;
	private Map<Integer, MenuItem> menu = null;
	private List<MenuItem> sortedMenu = null;

	synchronized public static MenuManager getInstance() {
		if ( theMenu == null ) {
			theMenu = new MenuManager();
		}
		return theMenu;
	}
	private MenuManager() {
		menu = new ConcurrentHashMap<Integer, MenuItem>();
		menu.put(new Integer( 22), new MenuItem( 22, "Egg Drop Soup", 3.00));
		menu.put(new Integer( 14), new MenuItem( 14, "WonTon Noodle Soup", 5.00));
		menu.put(new Integer(  6), new MenuItem(  6, "Egg Roll", 1.20));
		menu.put(new Integer( 17), new MenuItem( 17, "Spring Roll", 1.70));
		menu.put(new Integer(207), new MenuItem(207, "Roast Duck", 16.00));
		menu.put(new Integer( 77), new MenuItem( 77, "Shrimp with Snow Pea", 10.50));
		menu.put(new Integer( 98), new MenuItem( 98, "Beef with Brocolli", 8.40));
		menu.put(new Integer(108), new MenuItem(108, "Beef Ginger", 9.00));
		menu.put(new Integer(210), new MenuItem(210, "Moo Goo Stir Fry", 7.50));
		menu.put(new Integer(123), new MenuItem(123, "Lemon Chicken", 9.25));
		menu.put(new Integer(114), new MenuItem(114, "Sweet&Sour Ribs", 6.50));
		menu.put(new Integer(132), new MenuItem(132, "Sweet&Sour Chicken Balls", 8.60));
		menu.put(new Integer( 50), new MenuItem( 50, "Boiled Rice", 1.50));
		menu.put(new Integer( 63), new MenuItem( 63, "Vegetable Fried Rice", 3.00));
		sortedMenu = new LinkedList<MenuItem>();
		sortedMenu.addAll( menu.values() );
	    Collections.sort( sortedMenu );
	}


	public List<MenuItem> getMenu() {
		return sortedMenu;
	}
	
	public MenuItem getMenuItem( Integer key ) {
		return menu.get(key);
	}
	
  public static void main( String[] args) {
	  MenuManager mm = MenuManager.getInstance();
	  for ( MenuItem mi : mm.getMenu() ) {
		  System.out.println( mi);
	  }
  }
}
