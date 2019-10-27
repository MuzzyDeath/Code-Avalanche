package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "Skyrim.mp3" };
	
	private AudioPlayer audio;

	private CharacterPane characterPane;
	private MenuPane menuPane;
	private ControlPane controlPane;
	private LevelPane levelPane;
	
	private Item[] itemList;
	private Map[] mapList;
	
	private Player pc;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		setTitle("King of BloodCity");
		
		System.out.println("If you see this, use the Java Applet, not the this!");
		menuPane = new MenuPane(this);
		characterPane = new CharacterPane(this);
		controlPane = new ControlPane(this);
		levelPane = new LevelPane(this);
		
		mapList = levelPane.world;
		
		generateItems();
		switchToMenu();
	}
	
	private void generateItems() {
		itemList = new Item[50];
		Item.generateItemList(itemList);
		Item.printItemList();
	}
	
	public void switchToMenu() {
		playMenuMusic();
		switchToScreen(menuPane);
	}
	public void switchToCharacterPane() {
		switchToScreen(characterPane);
	}
	public void switchToControlPane() {
		switchToScreen(controlPane);
	}
	public void switchToLevelPane() {
		audio.stopSound(MUSIC_FOLDER, SOUND_FILES[0]);
		switchToScreen(levelPane);
	}
	
	private void playMenuMusic() {
		audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);
	}
	
	//Below are examples of how to call GUI panes.
	
	/*
	public void switchToSomePane() {
		playRandomSound();
		switchToScreen(somePane);
	}
	 */
	
	/*
	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);
	}
	*/
}