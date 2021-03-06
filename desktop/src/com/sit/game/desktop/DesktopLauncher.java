package com.sit.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sit.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SpaceInvaders";
		config.useGL30 = true;
		config.width = MainGame.WIDTH;
		config.height = MainGame.HEIGHT;
		new LwjglApplication(new MainGame(), config);
	}
}
