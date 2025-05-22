package com.dipto.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {
    public Vector2 position;
    public static final int SIZE = 50;
    public Vector2 getPosition() {
        return position;
    }
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, SIZE, SIZE);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

}
