package com.dipto.game.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.dipto.game.model.Cat;

public class InputHandler extends InputAdapter {
    private Cat cat;

    public InputHandler(Cat cat) {
        this.cat = cat;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.RIGHT: cat.moveRight(); break;
            case Input.Keys.LEFT: cat.moveLeft(); break;
            case Input.Keys.UP: cat.moveUp(); break;
            case Input.Keys.DOWN: cat.moveDown(); break;
        }
        return true;
    }
}
