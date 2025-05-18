package com.dipto.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall {
    private Vector2 position;
    private static final int SIZE = 50;

    public Wall(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, SIZE, SIZE);
    }

    public static int getSize() {
        return SIZE;
    }
}
