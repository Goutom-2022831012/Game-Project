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

public class GameScreen implements Screen {
   private SpriteBatch batch;
   private Pacman pacman;
   private PacmanRenderer pacmanRenderer;
    private Maze maze;
    private MazeRenderer mazeRenderer;
    private MainGame game;
    private OrthographicCamera camera;

    public GameScreen(MainGame game) {
        this.game = game;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        pacman = new Pacman(100,100,50);
        maze = new Maze();
        mazeRenderer = new MazeRenderer();
        pacmanRenderer = new PacmanRenderer();
        Gdx.input.setInputProcessor(new InputHandler(pacman));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pacman.update(delta);
        batch.begin();
        mazeRenderer.render(batch,maze);
        pacmanRenderer.render(batch , pacman);
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

    }
}
