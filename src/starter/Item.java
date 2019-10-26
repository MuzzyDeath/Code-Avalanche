package starter;

public class Item {
	private ItemType iType;
	private String itemName;
	private int mutator;
	
	private static Item[] Item;
	
	public Item(ItemType i, String name, int m) {
		// TODO Auto-generated constructor stub
		this.iType = i;
		this.itemName = name;
		this.mutator = m;
	}
	
	public static void main(String[] args) {
		Item = new Item[50];
		
		Item[0] = new Item(ItemType.STRENGTH, "Brawn (+2 STR)", 2);
		Item[1]=  new Item(ItemType.AGILITY, "Swift Sandals (+1 AGL)", 1);
		Item[2] = new Item(ItemType.AGILITY, "Speed (+2 AGL)", 2);
        Item[3] = new Item(ItemType.CHARISMA, "Charm (+2 CHRS)", 2);
        Item[4] = new Item(ItemType.DEFENSE, "Metallic Armor (+1 DEF)", 1);
        Item[5] = new Item(ItemType.STRENGTH, "Full Power (+3 STR)", 3);
        Item[6] = new Item(ItemType.DEFENSE, "Iron Body (+1 DEF)", 1);
        Item[7] = new Item(ItemType.CHARISMA, "Photogenic Person (+2 CHRS)", 2);
        Item[8] = new Item(ItemType.AGILITY, "Electric Movement (+3 AGL)", 3);
        Item[9] = new Item(ItemType.AGILITY, "Flashstep (+3 AGL)", 3);
        Item[10] = new Item(ItemType.CHARISMA, "Soothing Tunes (+3 CHRS)", 3);
        Item[11] = new Item(ItemType.DEFENSE, "Density Cube (+2 DEF)", 2);
        Item[12] = new Item(ItemType.AGILITY, "Sonido (+4 AGL)", 4);
        Item[13] = new Item(ItemType.STRENGTH, "Burst Gate (+4 STR)", 4);
        Item[14] = new Item(ItemType.CHARISMA, "Wizard's charm (+4 CHRS)", 4);
        Item[15] = new Item(ItemType.DEFENSE, "Iron Defense (+3 DEF)", 3);
        Item[16] = new Item(ItemType.DEFENSE, "Diamond Surface (+3 DEF)", 3);
        Item[17] = new Item(ItemType.STRENGTH, "Muscular impact (+5 STR)", 5);
        Item[18] = new Item(ItemType.CHARISMA, "Kindness (+5 CHRS)", 5);
        Item[19] = new Item(ItemType.STRENGTH, "Warrior's Spirit (+6 STR)", 6);
        Item[20] = new Item(ItemType.AGILITY, "Mach 5 (+5 AGL)", 5);
        Item[21] = new Item(ItemType.AGILITY, "Hermes' footwear (+6 AGL)", 6);
        Item[22] = new Item(ItemType.CHARISMA, "Compassion (+6 CHRS)", 6);
        Item[23] = new Item(ItemType.DEFENSE, "Rogue's Guard (+4 DEF)", 4);
        Item[24] = new Item(ItemType.STRENGTH, "Energy Flames (+7 STR)", 7);
        Item[25] = new Item(ItemType.DEFENSE, "Shield Of Protection (+4 DEF)", 4);
        Item[26] = new Item(ItemType.CHARISMA, "Helpful Nature (+7 CHRS)", 7);
        Item[27] = new Item(ItemType.AGILITY, "Rocket shoes (+7 AGL)", 7);
        Item[28] = new Item(ItemType.AGILITY, "Magister's shoes (+8 AGL)", 8);
        Item[29] = new Item(ItemType.CHARISMA, "Persuasion (+8 CHRS)", 8);
        Item[30] = new Item(ItemType.DEFENSE, "Hero's Shield (+5 DEF)", 5);
        Item[31] = new Item(ItemType.AGILITY, "Old running shoes (+9 AGL)", 9);
        Item[32] = new Item(ItemType.STRENGTH, "Super Power (+8 STR)", 8);
        Item[33] = new Item(ItemType.CHARISMA, "Fake Gold (+9 CHRS)", 9);
        Item[34] = new Item(ItemType.DEFENSE, "Endurance (+6 DEF)", 6);
        Item[35] = new Item(ItemType.DEFENSE, "God's Shield (+7 DEF)", 7);
        Item[36] = new Item(ItemType.STRENGTH, "Rage (+9 STR)", 9);
        Item[37] = new Item(ItemType.CHARISMA, "Mage's Charm (+9 CHRS)", 9);
        Item[38] = new Item(ItemType.STRENGTH, "200% Full Power (+9 STR)", 9);
        Item[39] = new Item(ItemType.AGILITY, "Good running shoes (+9 AGL)", 9);
        Item[40] = new Item(ItemType.AGILITY, "Premium running shoes (+10 AGL)", 10);
        Item[41] = new Item(ItemType.CHARISMA, "Personality (+10 CHRS)", 10);
        Item[42] = new Item(ItemType.DEFENSE, "Impenetrable Hide (+8 DEF)", 8);
        Item[43] = new Item(ItemType.STRENGTH, "Infinity Sword (+10 STR)", 10);
        Item[44] = new Item(ItemType.DEFENSE, "The Will To Protect (+9 DEF)", 9);
        Item[45] = new Item(ItemType.CHARISMA, "Magical Mirror (+10 CHRS)", 10);
        Item[46] = new Item(ItemType.AGILITY, "Lightspeed (+9 AGL)", 9);
        Item[47] = new Item(ItemType.AGILITY, "Godspeed (+10 AGL)", 10);
        Item[48] = new Item(ItemType.CHARISMA, "Fake Infinity Sword (+10 CHRS)", 10);
        Item[49] = new Item(ItemType.DEFENSE, "Invicibility (+10 DEF)", 10);
		
    	for(int i = 0; i < 1; ++i) {
    		System.out.println("      INVENTORY ITEMS LIST      ");
			System.out.println("--------------------------------");
			System.out.println("Item 1 : " + Item[0].itemName);
			System.out.println("Item 2 : " + Item[1].itemName);
			System.out.println("Item 3 : " + Item[2].itemName);
			System.out.println("Item 4 : " + Item[3].itemName);
			System.out.println("Item 5 : " + Item[4].itemName);
			System.out.println("Item 6 : " + Item[5].itemName);
			System.out.println("Item 7 : " + Item[6].itemName);
			System.out.println("Item 8 : " + Item[7].itemName);
			System.out.println("Item 9 : " + Item[8].itemName);
			System.out.println("Item 10 : " + Item[9].itemName);
			System.out.println("--------------------------------");
    	}
	}
}
