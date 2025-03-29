package com.dipto.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.model.Maze;
import com.dipto.game.model.Wall;

public class MazeRenderer {
    private Texture wallTexture;

    public MazeRenderer() {
        wallTexture = new Texture("wall.png");
    }

    public void render(SpriteBatch batch, Maze maze) {
        for (Wall wall : maze.getWalls()) {
            batch.draw(wallTexture, wall.getPosition().x, wall.getPosition().y, Wall.getSize(), Wall.getSize());
        }
    }

    public void dispose() {
        wallTexture.dispose();
    }
}
