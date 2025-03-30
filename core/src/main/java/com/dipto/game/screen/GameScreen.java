package com.dipto.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.MainGame;
import com.dipto.game.model.Pacman;
import com.dipto.game.view.PacmanRenderer;
import com.dipto.game.input.InputHandler;
import com.dipto.game.model.Maze;
import com.dipto.game.view.MazeRenderer;
import com.dipto.game.model.Alien;
import com.dipto.game.view.AlienRenderer;
import java.util.List;

public class GameScreen implements Screen {
   private SpriteBatch batch;
   private Pacman pacman;
   private PacmanRenderer pacmanRenderer;
    private Maze maze;
    private MazeRenderer mazeRenderer;
    private MainGame game;
    private OrthographicCamera camera;
    private Alien alien;
    private AlienRenderer alienRenderer;

    public GameScreen(MainGame game) {
        this.game = game;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        pacman = new Pacman(100,100,20);
        maze = new Maze();
        mazeRenderer = new MazeRenderer();
        pacmanRenderer = new PacmanRenderer();
        alien = new Alien(400, 300, 50 ); // Start position of the Alien
        alienRenderer = new AlienRenderer();
        Gdx.input.setInputProcessor(new InputHandler(pacman));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pacman.update(delta,maze.getWalls());
        alien.update(delta, pacman);
        batch.begin();
        mazeRenderer.render(batch,maze);
        pacmanRenderer.render(batch , pacman);
        alienRenderer.render(batch, alien);
        batch.end();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {
        batch.dispose();
        mazeRenderer.dispose();
        pacmanRenderer.dispose();
        alienRenderer.dispose();

    }
}
