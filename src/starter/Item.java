package starter;

public class Item {
	private ItemType iType;
	private String itemName;
	private int mutator;
	
	private static Item[] Items;
	
	public Item(ItemType i, String name, int m) {
		// TODO Auto-generated constructor stub
		this.iType = i;
		this.itemName = name;
		this.mutator = m;
	}
	
	public static Item[] generateItemList() {
		Items[0] = new Item(ItemType.STRENGTH, "Brawn (+2 STR)", 2);
		Items[1]=  new Item(ItemType.AGILITY, "Swift Sandals (+1 AGL)", 1);
		Items[2] = new Item(ItemType.AGILITY, "Speed (+2 AGL)", 2);
        Items[3] = new Item(ItemType.CHARISMA, "Charm (+2 CHRS)", 2);
        Items[4] = new Item(ItemType.DEFENSE, "Metallic Armor (+1 DEF)", 1);
        Items[5] = new Item(ItemType.STRENGTH, "Full Power (+3 STR)", 3);
        Items[6] = new Item(ItemType.DEFENSE, "Iron Body (+1 DEF)", 1);
        Items[7] = new Item(ItemType.CHARISMA, "Photogenic Person (+2 CHRS)", 2);
        Items[8] = new Item(ItemType.AGILITY, "Electric Movement (+3 AGL)", 3);
        Items[9] = new Item(ItemType.AGILITY, "Flashstep (+3 AGL)", 3);
        Items[10] = new Item(ItemType.CHARISMA, "Soothing Tunes (+3 CHRS)", 3);
        Items[11] = new Item(ItemType.DEFENSE, "Density Cube (+2 DEF)", 2);
        Items[12] = new Item(ItemType.AGILITY, "Sonido (+4 AGL)", 4);
        Items[13] = new Item(ItemType.STRENGTH, "Burst Gate (+4 STR)", 4);
        Items[14] = new Item(ItemType.CHARISMA, "Wizard's charm (+4 CHRS)", 4);
        Items[15] = new Item(ItemType.DEFENSE, "Iron Defense (+3 DEF)", 3);
        Items[16] = new Item(ItemType.DEFENSE, "Diamond Surface (+3 DEF)", 3);
        Items[17] = new Item(ItemType.STRENGTH, "Muscular impact (+5 STR)", 5);
        Items[18] = new Item(ItemType.CHARISMA, "Kindness (+5 CHRS)", 5);
        Items[19] = new Item(ItemType.STRENGTH, "Warrior's Spirit (+6 STR)", 6);
        Items[20] = new Item(ItemType.AGILITY, "Mach 5 (+5 AGL)", 5);
        Items[21] = new Item(ItemType.AGILITY, "Hermes' footwear (+6 AGL)", 6);
        Items[22] = new Item(ItemType.CHARISMA, "Compassion (+6 CHRS)", 6);
        Items[23] = new Item(ItemType.DEFENSE, "Rogue's Guard (+4 DEF)", 4);
        Items[24] = new Item(ItemType.STRENGTH, "Energy Flames (+7 STR)", 7);
        Items[25] = new Item(ItemType.DEFENSE, "Shield Of Protection (+4 DEF)", 4);
        Items[26] = new Item(ItemType.CHARISMA, "Helpful Nature (+7 CHRS)", 7);
        Items[27] = new Item(ItemType.AGILITY, "Rocket shoes (+7 AGL)", 7);
        Items[28] = new Item(ItemType.AGILITY, "Magister's shoes (+8 AGL)", 8);
        Items[29] = new Item(ItemType.CHARISMA, "Persuasion (+8 CHRS)", 8);
        Items[30] = new Item(ItemType.DEFENSE, "Hero's Shield (+5 DEF)", 5);
        Items[31] = new Item(ItemType.AGILITY, "Old running shoes (+9 AGL)", 9);
        Items[32] = new Item(ItemType.STRENGTH, "Super Power (+8 STR)", 8);
        Items[33] = new Item(ItemType.CHARISMA, "Fake Gold (+9 CHRS)", 9);
        Items[34] = new Item(ItemType.DEFENSE, "Endurance (+6 DEF)", 6);
        Items[35] = new Item(ItemType.DEFENSE, "God's Shield (+7 DEF)", 7);
        Items[36] = new Item(ItemType.STRENGTH, "Rage (+9 STR)", 9);
        Items[37] = new Item(ItemType.CHARISMA, "Mage's Charm (+9 CHRS)", 9);
        Items[38] = new Item(ItemType.STRENGTH, "200% Full Power (+9 STR)", 9);
        Items[39] = new Item(ItemType.AGILITY, "Good running shoes (+9 AGL)", 9);
        Items[40] = new Item(ItemType.AGILITY, "Premium running shoes (+10 AGL)", 10);
        Items[41] = new Item(ItemType.CHARISMA, "Personality (+10 CHRS)", 10);
        Items[42] = new Item(ItemType.DEFENSE, "Impenetrable Hide (+8 DEF)", 8);
        Items[43] = new Item(ItemType.STRENGTH, "Infinity Sword (+10 STR)", 10);
        Items[44] = new Item(ItemType.DEFENSE, "The Will To Protect (+9 DEF)", 9);
        Items[45] = new Item(ItemType.CHARISMA, "Magical Mirror (+10 CHRS)", 10);
        Items[46] = new Item(ItemType.AGILITY, "Lightspeed (+9 AGL)", 9);
        Items[47] = new Item(ItemType.AGILITY, "Godspeed (+10 AGL)", 10);
        Items[48] = new Item(ItemType.CHARISMA, "Fake Infinity Sword (+10 CHRS)", 10);
        Items[49] = new Item(ItemType.DEFENSE, "Invicibility (+10 DEF)", 10);
        
        return Items;
	}
	
	public Item[] getItemList() {
		return Items;
	}
	
	public Item getItem(int i) {
		return Items[i];
	}
	
	public static void printItemList() {
		System.out.println("--------------------------------\n");
		System.out.println("     INVENTORY ITEMS LIST      \n");
		System.out.println("--------------------------------\n");

		for(int i = 0; i < Items.length; i++) {
			System.out.println("Item " + i + ": " + Items[i].itemName + "\n");
		}

		System.out.println("--------------------------------\n");
	}

	public static void main(String[] args) {
		Items = new Item[50];
		generateItemList();
		printItemList();
	}
}
