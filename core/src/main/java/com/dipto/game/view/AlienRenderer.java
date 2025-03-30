package com.dipto.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.model.Alien;

public class AlienRenderer {
    private Texture alienTexture;

    public AlienRenderer() {
        alienTexture = new Texture("alien.png");
    }

    public void render(SpriteBatch batch, Alien alien) {
        if (alien.isActive()) {
            batch.draw(alienTexture, alien.getPosition().x, alien.getPosition().y, 20, 20);
        }
    }

    public void dispose() {
        alienTexture.dispose();
    }
}
