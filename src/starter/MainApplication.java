package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "music";
	private static final String[] SOUND_FILES = { "Skyrim.mp3" };

	private CharacterPane characterPane;
	private MenuPane menu;
	private ControlPane controls;
	
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("If you see this, use the Java Applet, not the this!");
		characterPane = new CharacterPane(this);
		menu = new MenuPane(this);
		switchToMenu();
	}
	
	public void switchToMenu() {
		playRandomSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToCharacterPane() {
		playRandomSound();
		switchToScreen(characterPane);
	}
	
	/*
	public void switchToSomePane() {
		playRandomSound();
		switchToScreen(somePane);
	}
	 */

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]);
	}
}