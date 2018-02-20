package Core.logger;

import java.util.logging.Level;

public class LevelCustom extends Level {
	protected LevelCustom(String name, int value) {
		super(name, value);
	}
	public static final Level SKIP = new LevelCustom("SKIP", 900);
}
