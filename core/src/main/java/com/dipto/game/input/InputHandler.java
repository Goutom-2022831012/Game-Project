package com.dipto.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.dipto.game.model.Pacman;

public class InputHandler extends InputAdapter {
    private Pacman pacman;

    public InputHandler(Pacman pacman) {
        this.pacman = pacman;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.RIGHT: pacman.moveRight(); break;
            case Input.Keys.LEFT: pacman.moveLeft(); break;
            case Input.Keys.UP: pacman.moveUp(); break;
            case Input.Keys.DOWN: pacman.moveDown(); break;
        }
        return true;
    }
}
