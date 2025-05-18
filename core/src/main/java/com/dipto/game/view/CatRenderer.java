package com.dipto.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dipto.game.model.Cat;

public class CatRenderer {
    private Texture catTexture;

    public CatRenderer() {
        catTexture = new Texture("nom.png");
    }

    public void render(SpriteBatch batch, Cat cat) {
        batch.draw(catTexture, cat.getPosition().x, cat.getPosition().y, cat.getSize(), cat.getSize());
    }

    public void dispose() {
        catTexture.dispose();
    }
}
