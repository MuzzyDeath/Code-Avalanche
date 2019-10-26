package starter;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  @author Pranav Jammalamadaka
 */


public class Inventory {
	  public static enum InventoryType { STRENGTH, AGILITY, DEFENSE, CHARISMA; }

	    public InventoryType type;
	    public String itemname;


	    public Inventory(InventoryType type, String string) {
	        this.type = type;
	        this.itemname = itemname;
	    }
	    Inventory[] inventory = new Inventory[50];
	    

	    Inventory item1 = new Inventory(InventoryType.STRENGTH, "Brawn (+2 STR)");
        Inventory item2 = new Inventory(InventoryType.AGILITY, "Swift Sandals (+1 AGL)");
        Inventory item3 = new Inventory(InventoryType.AGILITY, "Speed (+2 AGL)");
        Inventory item4 = new Inventory(InventoryType.CHARISMA, "Charm (+2 CHRS)");
        Inventory item5 = new Inventory(InventoryType.DEFENSE, "Metallic Armor (+1 DEF)");
        Inventory item6 = new Inventory(InventoryType.STRENGTH, "Full Power (+3 STR)");
        Inventory item7 = new Inventory(InventoryType.DEFENSE, "Iron Body (+1 DEF)");
        Inventory item8 = new Inventory(InventoryType.CHARISMA, "Photogenic Person (+2 CHRS)");
        Inventory item9 = new Inventory(InventoryType.AGILITY, "Electric Movement (+3 AGL)");
        Inventory item10 = new Inventory(InventoryType.AGILITY, "Flashstep (+3 AGL)");
        Inventory item11 = new Inventory(InventoryType.CHARISMA, "Soothing Tunes (+3 CHRS)");
        Inventory item12 = new Inventory(InventoryType.DEFENSE, "Density Cube (+2 DEF)");
        Inventory item13 = new Inventory(InventoryType.AGILITY, "Sonido (+4 AGL)");
        Inventory item14 = new Inventory(InventoryType.STRENGTH, "Burst Gate (+4 STR)");
        Inventory item15 = new Inventory(InventoryType.CHARISMA, "Wizard's charm (+4 CHRS)");
        Inventory item16 = new Inventory(InventoryType.DEFENSE, "Iron Defense (+3 DEF)");
        Inventory item17 = new Inventory(InventoryType.DEFENSE, "Diamond Surface (+3 DEF)");
        Inventory item18 = new Inventory(InventoryType.STRENGTH, "Muscular impact (+5 STR)");
        Inventory item19 = new Inventory(InventoryType.CHARISMA, "Kindness (+5 CHRS)");
        Inventory item20 = new Inventory(InventoryType.STRENGTH, "Warrior's Spirit (+6 STR)");
        Inventory item21 = new Inventory(InventoryType.AGILITY, "Mach 5 (+5 AGL)");
        Inventory item22 = new Inventory(InventoryType.AGILITY, "Hermes' footwear (+6 AGL)");
        Inventory item23 = new Inventory(InventoryType.CHARISMA, "Compassion (+6 CHRS)");
        Inventory item24 = new Inventory(InventoryType.DEFENSE, "Rogue's Guard (+4 DEF)");
        Inventory item25 = new Inventory(InventoryType.STRENGTH, "Energy Flames (+7 STR)");
        Inventory item26 = new Inventory(InventoryType.DEFENSE, "Shield Of Protection (+4 DEF)");
        Inventory item27 = new Inventory(InventoryType.CHARISMA, "Helpful Nature (+7 CHRS)");
        Inventory item28 = new Inventory(InventoryType.AGILITY, "Rocket shoes (+7 AGL)");
        Inventory item29 = new Inventory(InventoryType.AGILITY, "Magister's shoes (+8 AGL)");
        Inventory item30 = new Inventory(InventoryType.CHARISMA, "Persuasion (+8 CHRS)");
        Inventory item31 = new Inventory(InventoryType.DEFENSE, "Hero's Shield (+5 DEF)");
        Inventory item32 = new Inventory(InventoryType.AGILITY, "Old running shoes (+9 AGL)");
        Inventory item33 = new Inventory(InventoryType.STRENGTH, "Super Power (+8 STR)");
        Inventory item34 = new Inventory(InventoryType.CHARISMA, "Fake Gold (+9 CHRS)");
        Inventory item35 = new Inventory(InventoryType.DEFENSE, "Endurance (+6 DEF)");
        Inventory item36 = new Inventory(InventoryType.DEFENSE, "God's Shield (+7 DEF)");
        Inventory item37 = new Inventory(InventoryType.STRENGTH, "Rage (+9 STR)");
        Inventory item38 = new Inventory(InventoryType.CHARISMA, "Mage's Charm (+9 CHRS)");
        Inventory item39 = new Inventory(InventoryType.STRENGTH, "200% Full Power (+9 STR)");
        Inventory item40 = new Inventory(InventoryType.AGILITY, "Good running shoes (+9 AGL)");
        Inventory item41 = new Inventory(InventoryType.AGILITY, "Premium running shoes (+10 AGL)");
        Inventory item42 = new Inventory(InventoryType.CHARISMA, "Personality (+10 CHRS)");
        Inventory item43 = new Inventory(InventoryType.DEFENSE, "Impenetrable Hide (+8 DEF)");
        Inventory item44 = new Inventory(InventoryType.STRENGTH, "Infinity Sword (+10 STR)");
        Inventory item45 = new Inventory(InventoryType.DEFENSE, "The Will To Protect (+9 DEF)");
        Inventory item46 = new Inventory(InventoryType.CHARISMA, "Magical Mirror (+10 CHRS)");
        Inventory item47 = new Inventory(InventoryType.AGILITY, "Lightspeed (+9 AGL)");
        Inventory item48 = new Inventory(InventoryType.AGILITY, "Godspeed (+10 AGL)");
        Inventory item49 = new Inventory(InventoryType.CHARISMA, "Fake Infinity Sword (+10 CHRS)");
        Inventory item50 = new Inventory(InventoryType.DEFENSE, "Invicibility (+10 DEF)");
		
}
