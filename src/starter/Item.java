package starter;

import starter.Inventory.InventoryType;

public class Item {
	private ItemType iType;
	private String itemName;
	private int mutator;
	
	private static Item[] items;
	
	public Item(ItemType i, String name, int m) {
		// TODO Auto-generated constructor stub
		Inventory item1 = new Inventory(InventoryType.STRENGTH, "Brawn (+2 STR)");
        Inventory item2 = new Inventory(InventoryType.AGILITY, "Swift Sandals (+1 AGL)");
	}
	
	public static void main(String[] args) {
		items = new Item[50];
		
	}

}
