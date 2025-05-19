package com.dipto.game.screen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.MainGame;

public class IntroScreen implements Screen {
    private final MainGame game;  // Replace with your main game class
    private SpriteBatch batch;
    private BitmapFont font;
    private Texture introImage;

    public IntroScreen(MainGame game) {
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.BLACK);
        introImage = new Texture(Gdx.files.internal("intro.png"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(introImage, 0, 0, 980, 1000);
        font.draw(batch, "Cat vs Pepe", 500, 200);
        font.draw(batch, "Use arrow keys to move the Cat.", 500, 160);
        font.draw(batch, "Avoid the Pepes chasing you!", 500, 130);
        font.draw(batch, "Press ENTER to Start", 500, 90);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override public void resize(int width, int height) {}
    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        introImage.dispose();
    }
}
