package starter;
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
			case WARRIOR: return "warrior";
			case MAGE: return "mage";
			case ROGUE: return "rogue";
			case NPC: return "npc";
		}
		return "n/a";
	}
}