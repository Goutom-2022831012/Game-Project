package com.dipto.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.MainGame;

public class GameOverScreen implements Screen {
    private MainGame game;
    private SpriteBatch batch;
    private BitmapFont font;

    public GameOverScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.getData().setScale(3);
        font.draw(batch, "GAME OVER", Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2);
        batch.end();

        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE)) {
            game.setScreen(new GameScreen(game));
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
