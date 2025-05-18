package com.dipto.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.dipto.game.MainGame;
import com.dipto.game.model.Cat;
import com.dipto.game.view.CatRenderer;
import com.dipto.game.input.InputHandler;
import com.dipto.game.model.Maze;
import com.dipto.game.view.MazeRenderer;
import com.dipto.game.model.Pepe;
import com.dipto.game.view.PepeRenderer;
import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Cat cat;
    private CatRenderer catRenderer;
    private Maze maze;
    private MazeRenderer mazeRenderer;
    private MainGame game;
    private List<Pepe> pepes;
    private PepeRenderer pepeRenderer;
    private Music backgroundMusic;  // <-- Added music
    private float elapsedTime = 0f;
    private int lastPrintedSecond = -1;
    private BitmapFont font;

    public GameScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        cat = new Cat(100, 100, 20);
        maze = new Maze();
        mazeRenderer = new MazeRenderer();
        catRenderer = new CatRenderer();
        pepeRenderer = new PepeRenderer();
        Gdx.input.setInputProcessor(new InputHandler(cat));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(0.5f);
        backgroundMusic.play();
        font = new BitmapFont();
        font.getData().setScale(2.0f);
        font.setColor(Color.WHITE);
        pepes = new ArrayList<>();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float segmentWidth = screenWidth / 6;
        pepes.add(new Pepe(0, 0, 60, 0, 1000));
        pepes.add(new Pepe(10, 10, 70, 0, 1000));
        pepes.add(new Pepe(20, 20, 80, 0, 1000));


        for (int i = 0; i < 6; i++) {
            float leftBoundary = segmentWidth * i;
            float rightBoundary = segmentWidth * (i + 1);
            float xPosition = (leftBoundary + rightBoundary) / 2 - 10;
            float yPosition = screenHeight / 2;
            pepes.add(new Pepe(xPosition, yPosition, 70, leftBoundary, rightBoundary));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cat.update(delta, maze.getWalls());
        elapsedTime += delta;
        int currentSecond = (int) elapsedTime;

        if (currentSecond != lastPrintedSecond) {
            lastPrintedSecond = currentSecond;
            System.out.println("Elapsed time: " + currentSecond + " seconds");
        }
        String timeString = "Survival Time: " + (int) elapsedTime;
        float x = Gdx.graphics.getWidth() - 250;
        float y = Gdx.graphics.getHeight() - 10;

        for (Pepe pepe : pepes) {
            pepe.update(delta, cat);
            if (isCatCollidingWithPepe(pepe)) {
                backgroundMusic.stop();
                game.setScreen(new GameOverScreen(game, (int) elapsedTime));
                return;
            }
        }


        batch.begin();
        mazeRenderer.render(batch, maze);
        catRenderer.render(batch, cat);

        for (Pepe pepe : pepes) {
            pepeRenderer.render(batch, pepe);
        }
        font.draw(batch, timeString, x, y);
        batch.end();
    }

    private boolean isCatCollidingWithPepe(Pepe pepe) {
        Rectangle catBounds = new Rectangle(cat.getPosition().x, cat.getPosition().y, cat.getSize(), cat.getSize());
        Rectangle pepeBounds = new Rectangle(pepe.getPosition().x, pepe.getPosition().y, 20, 20);
        return catBounds.overlaps(pepeBounds);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        mazeRenderer.dispose();
        catRenderer.dispose();
        pepeRenderer.dispose();
        backgroundMusic.dispose();
        font.dispose();
    }
}
