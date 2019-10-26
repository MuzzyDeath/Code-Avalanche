package starter;

public class Item {
	private ItemType iType;
	private String itemName;
	private int mutator;
	
	private static Item[] items;
	
	public Item(ItemType i, String name, int m) {
		// TODO Auto-generated constructor stub
		this.iType = i;
		this.itemName = name;
		this.mutator = m;
	}
	
	public static void main(String[] args) {
		items = new Item[50];
		
		items[0] = new Item(ItemType.STRENGTH, "Brawn (+2 STR)", 2);
        items[1]= new Item(ItemType.AGILITY, "Swift Sandals (+1 AGL)", 1);
        items[2] = new Item(ItemType.AGILITY, "Speed (+2 AGL)", 2);
        items[3] = new Item(ItemType.CHARISMA, "Charm (+2 CHRS)", 2);
        items[4] = new Item(ItemType.DEFENSE, "Metallic Armor (+1 DEF)", 1);
        items[5] = new Item(ItemType.STRENGTH, "Full Power (+3 STR)", 3);
        items[6] = new Item(ItemType.DEFENSE, "Iron Body (+1 DEF)", 1);
        items[7] = new Item(ItemType.CHARISMA, "Photogenic Person (+2 CHRS)", 2);
        items[8] = new Item(ItemType.AGILITY, "Electric Movement (+3 AGL)", 3);
        items[9] = new Item(ItemType.AGILITY, "Flashstep (+3 AGL)", 3);
		
		
		
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}

}
