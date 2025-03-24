package com.dipto.game.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.dipto.game.MainGame;

public class Lwjgl3Launcher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Pacman Game ");
        config.setWindowedMode(800, 800);
        config.setForegroundFPS(60); // Set FPS limit
        new Lwjgl3Application(new MainGame(), config);
    }
}
