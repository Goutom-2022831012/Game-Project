package com.dipto.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dipto.game.MainGame;
import com.dipto.game.model.Pacman;
import com.dipto.game.view.PacmanRenderer;
import com.dipto.game.input.InputHandler;
import com.dipto.game.model.Maze;
import com.dipto.game.view.MazeRenderer;
import com.dipto.game.model.Alien;
import com.dipto.game.view.AlienRenderer;
import com.dipto.game.model.Wall;


import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Pacman pacman;
    private PacmanRenderer pacmanRenderer;
    private Maze maze;
    private MazeRenderer mazeRenderer;
    private MainGame game;
    private List<Alien> aliens;
    private AlienRenderer alienRenderer;

    public GameScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        pacman = new Pacman(100, 100, 15);
        maze = new Maze();
        mazeRenderer = new MazeRenderer();
        pacmanRenderer = new PacmanRenderer();
        alienRenderer = new AlienRenderer();
        Gdx.input.setInputProcessor(new InputHandler(pacman));

        aliens = new ArrayList<>();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float segmentWidth = screenWidth / 6;

        for (int i = 0; i < 6; i++) {
            float leftBoundary = segmentWidth * i;
            float rightBoundary = segmentWidth * (i + 1);
            float xPosition = (leftBoundary + rightBoundary) / 2 - 10;
            float yPosition = screenHeight / 2; // Middle of the screen
            aliens.add(new Alien(xPosition, yPosition, 50, leftBoundary, rightBoundary));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pacman.update(delta, maze.getWalls());

        for (Alien alien : aliens) {
            alien.update(delta, pacman);
            if (isPacmanCollidingWithAlien(alien)) {
                game.setScreen(new GameOverScreen(game));
                return;
            }
        }

        batch.begin();
        mazeRenderer.render(batch, maze);
        pacmanRenderer.render(batch, pacman);

        for (Alien alien : aliens) {
            alienRenderer.render(batch, alien);
        }

        batch.end();
    }

    private boolean isPacmanCollidingWithAlien(Alien alien) {
        Rectangle pacmanBounds = new Rectangle(pacman.getPosition().x, pacman.getPosition().y, pacman.getSize(), pacman.getSize());
        Rectangle alienBounds = new Rectangle(alien.getPosition().x, alien.getPosition().y, 20, 20);
        return pacmanBounds.overlaps(alienBounds);
    }

    @Override
    public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        mazeRenderer.dispose();
        pacmanRenderer.dispose();
        alienRenderer.dispose();
    }
}
