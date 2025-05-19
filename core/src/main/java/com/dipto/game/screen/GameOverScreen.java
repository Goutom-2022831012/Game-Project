package com.dipto.game.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.dipto.game.MainGame;
import com.dipto.game.input.InputHandler;

public class GameOverScreen implements Screen {
    private MainGame game;
    private SpriteBatch batch;
    private BitmapFont font;
    private int survivalTime;

    public GameOverScreen(MainGame game, int survivalTime) {
        this.game = game;
        this.survivalTime = survivalTime;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(3);
        font.setColor(Color.WHITE);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE))

        {
            game.setScreen(new GameScreen(game));
        }
        batch.begin();
        font.draw(batch, "Game Over", Gdx.graphics.getWidth() / 2f - 100, Gdx.graphics.getHeight() / 2f + 50);
        font.draw(batch, "Survival Time: " + survivalTime + " seconds", Gdx.graphics.getWidth() / 2f - 150, Gdx.graphics.getHeight() / 2f - 10);
        font.draw(batch, "Press SPACE to Restart", Gdx.graphics.getWidth() / 2f - 150, Gdx.graphics.getHeight() / 2f - 70);
        batch.end();
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
