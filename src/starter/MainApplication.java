package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "Skyrim.mp3" };

	private CharacterPane characterPane;
	private MenuPane menuPane;
	private ControlPane controlPane;
	private LevelPane levelPane;
	
	private Item[] itemList;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("If you see this, use the Java Applet, not the this!");
		playMenuMusic();
		menuPane = new MenuPane(this);
		characterPane = new CharacterPane(this);
		controlPane = new ControlPane(this);
		levelPane = new LevelPane(this);
		
		generateItems();
		switchToMenu();
	}
	
	private void generateItems() {
		itemList = new Item[50];
		Item.generateItemList(itemList);
		Item.printItemList();
	}
	
	public void switchToMenu() {
		switchToScreen(menuPane);
	}
	public void switchToCharacterPane() {
		switchToScreen(characterPane);
	}
	public void switchToControlPane() {
		switchToScreen(controlPane);
	}
	public void switchToLevelPane() {
		switchToScreen(levelPane);
	}
	
	private void playMenuMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
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