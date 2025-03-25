package com.dipto.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.model.Pacman;

public class PacmanRenderer {
    private Texture pacmanTexture;

    public PacmanRenderer() {
        pacmanTexture = new Texture("pacman.png"); // Load image
    }

    public void render(SpriteBatch batch, Pacman pacman) {
        batch.draw(pacmanTexture, pacman.getPosition().x, pacman.getPosition().y, pacman.getSize(), pacman.getSize());
    }

    public void dispose() {
        pacmanTexture.dispose();
    }
}
