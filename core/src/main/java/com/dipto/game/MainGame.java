package com.dipto.game;

import com.badlogic.gdx.Game;
import com.dipto.game.screen.GameScreen;
import com.dipto.game.screen.IntroScreen;

public class MainGame extends Game {
    @Override
    public void create() {
        setScreen(new IntroScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
