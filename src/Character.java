import java.util.Scanner;
import java.util.Random;

/**
 *  @author Greg Jewell
 */

public class Character{

//Instance Variables
	//Private Usable only in this class
	protected CharacterType cType;
	private String cName;
	private int cRow, cCol, cMove, cHealth;
	private Space location;
	private boolean isPlayer;
	
	//Protected usable in this class and child class(es)
	protected int strength, charisma, agility, defense, balance, experience;
	
	//Public frowned upon, please do NOT implement any :)
	

/**
 * The constructor takes: 
 * @param CharacterType
 * @param row
 * @param col
 * 
 * The row/column are used to set the location they occupy.
 * 
 * There is a lot of information here, so that it can be adjusted if needed, rather than
 * being spread over multiple classes
 * 
 * The CharacterType is assigned here in the parameters, but it should actually be
 * selected via a click or keyboard selection from the user!
 */
	
// Character Constructor
// TODO: Finish adding the variables and functions associated with the Character Class
	public Character(CharacterType style, int row, int col) {
		this.cType = style;
		this.cRow = row;
		this.cCol = col;
		this.cHealth = 100;
		this.location = new Space(cRow, cCol);
		
		//Building Character Skills (All should total to 10, except NPC)
		if(style == CharacterType.WARRIOR) {
			this.strength = 4;
			this.charisma = 1;
			this.agility = 3;
			this.defense = 2;
			this.isPlayer = true;
			this.balance = 5000;
		}
		else if(style == CharacterType.ROGUE) {
			this.strength = 3;
			this.charisma = 4;
			this.agility = 2;
			this.defense = 1;
			this.isPlayer = true;
			this.balance = 5000;
		}
		else if(style == CharacterType.MAGE) {
			this.strength = 1;
			this.charisma = 2;
			this.agility = 3;
			this.defense = 4;
			this.isPlayer = true;
			this.balance = 5000;
		}
		else {
			this.strength = 1;
			this.charisma = 1;
			this.agility = 1;
			this.defense = 1;
			this.isPlayer = false;
			this.balance = 0;
		}
		
		//Get Player Name & Make NPC Names
		this.cName = setName();
	}
	
//Basic Setters(Mutators)
	//Set User name
	public String setName() {
		String name;
		
		if(this.isPlayer) {
			System.out.println("Please enter your character's name: ");
			name = new Scanner(System.in).next();
			this.cName = name;
		}
		else {
			this.cName = npcNames();
			name = this.cName;
		}

		return name;
	}
	
	//Set User class
	@SuppressWarnings("resource")
	public static CharacterType setCharacterType(Player temp) {
		int choice = 0;
		
		System.out.println("Please select the NUMBER of your class:\n");
		printWarrior();
		printRogue();
		printMage();
		choice = new Scanner(System.in).nextInt();
		
		if(choice == 1) {
			System.out.println("Warrior Selected");
			return CharacterType.WARRIOR;
		}
		else if(choice == 2) {
			System.out.println("Rogue Selected");
			return CharacterType.ROGUE;
		}
		else if(choice == 3) {
			System.out.println("Mage Selected");
			return CharacterType.MAGE;
		}
		else {
			System.out.println("The number entered is incorrect, please re-enter a number\n");
			choice = 0;
			setCharacterType(temp);
			return temp.cType;
		}
	}

//Basic Getters(Accessors)
	public int getStrength() {
		return this.strength;
	}
	public int getCharisma() {
		return this.charisma;
	}
	public int getAgility() {
		return this.agility;
	}
	public int getDefense() {
		return this.defense;
	}
	public int getHealth() {
		return this.cHealth;
	}
	public String getName() {
		return this.cName;
	}

//Returns Character type (Warrior, Rogue, ....)
	public CharacterType getCharacterType() {
		return cType;
	}
	
	public void Move(int numSpaces) {
		cMove = numSpaces;
	}
	
	public void ifIWereToMove(int numSpaces) {
		cMove = numSpaces;
		//"If I were to move...."
	}
		
	/**
	 * Calculates an array of the spaces that would be traveled if a character
	 * were to move numSpaces
	 * 
	 * @param numSpaces
	 *            The number of spaces to move (can be negative or positive)
	 * @return The array of Spaces that would need to be checked for Characters
	 */
	public Space[] spacesOccupiedOnTrail(int numSpaces) {
		cMove = numSpaces;
				
//Needs to return a value of type Space[];
		return null;	
	}
	
	public static void printSpaces(Space[] V) {
		for(int i = 0; i < V.length; ++i) {
			System.out.println("Position " + i + ": R" + V[i].getRow() + "C" + V[i].getCol());
		} 
	}
	
	public String npcNames() {
		String name;
		String[] names = {"Pranav", "Nitin", "Greg", "Cooper", "Samantha", "Cherlynn", "Tiffany", "Amber"};
		int index = (int)(Math.random() * names.length);
		name = names[index];
		
		return name;
	}
	
	public static void printWarrior() {
		System.out.println("(1) Warrior:\nStrength: 4\nCharisma: 1\nAgility: 3\nDefense: 2\n");
	}
	public static void printRogue() {
		System.out.println("(2) Rogue:\nStrength: 3\nCharisma: 4\nAgility: 2\nDefense: 1\n");
	}
	public static void printMage() {
		System.out.println("(3) Mage:\nStrength: 1\nCharisma: 2\nAgility: 3\nDefense: 4\n");
	}
	
//String override
	@Override
	public String toString() {
		System.out.println("\nInformation for : " + this.getName() + "\n");
		System.out.println("Strength: " + this.getStrength() + "\n");
		System.out.println("Charisma: " + this.getCharisma() + "\n");
		System.out.println("Agility: " + this.getAgility() + "\n");
		System.out.println("Defense: " + this.getDefense() + "\n");
		return "---------------------------------------------";
	}
	
	public static void main(String[] args) {
		Player Muzzy = null;
		CharacterType type = Muzzy.setCharacterType(Muzzy);
		Muzzy = new Player(type, 8, 3);
		Muzzy.printPlayer();
		
		//Character John = new Character(CharacterType.NPC, 1, 3);
		//John.toString();
		
	}
}