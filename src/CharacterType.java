/**
 * Borrowed from O. Jimenez's TrafficJam VehicleType Enumerator
 * 
 * @author CodeAvalanche
 *
 */
public enum CharacterType {
	WARRIOR, MAGE, ROGUE, NPC;
	
	public String toString() {
		switch(this) {
			case WARRIOR: return "Warrior";
			case MAGE: return "Mage";
			case ROGUE: return "Rogue";
			case NPC: return "NPC";
		}
		return "n/a";
	}
}