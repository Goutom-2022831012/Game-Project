package com.dipto.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.model.Pepe;

public class PepeRenderer {
    private Texture pepeTexture;

    public PepeRenderer() {
        pepeTexture = new Texture("pepe.png");
    }

    public void render(SpriteBatch batch, Pepe pepe) {
            batch.draw(pepeTexture, pepe.getPosition().x, pepe.getPosition().y, 20, 20);

    }

    public void dispose() {
        pepeTexture.dispose();
    }
}
