package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1600;
	public static final int WINDOW_HEIGHT = 1200;
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "Skyrim.mp3" };

	private CharacterPane characterPane;
	private MenuPane menuPane;
	private ControlPane controlPane;
	
	private Item[] itemList;
	
	//private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("If you see this, use the Java Applet, not the this!");
		playMenuMusic();
		menuPane = new MenuPane(this);
		characterPane = new CharacterPane(this);
		controlPane = new ControlPane(this);
		itemList = new Item[50];
		itemList.toString();
		switchToMenu();
	}
	
	public void switchToMenu() {
		//count++;
		switchToScreen(menuPane);
	}
	public void switchToCharacterPane() {
		switchToScreen(characterPane);
	}
	public void switchToControlPane() {
		switchToScreen(controlPane);
	}
	
	private void playMenuMusic() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);
	}
	
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