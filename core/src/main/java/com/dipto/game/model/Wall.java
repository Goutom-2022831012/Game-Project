package com.dipto.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall extends Obstacle {

    public Wall(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return super.getPosition();
    }

    public Rectangle getBounds() {
        return super.getBounds();
    }

    public static int getSize() {
        return SIZE;
    }
}
