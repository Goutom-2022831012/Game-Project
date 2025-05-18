package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;

public class Pepe {
    private Vector2 position;
    private float speed;
    private boolean isActive;
    private static final float SIZE = 50;
    private float leftBoundary, rightBoundary;

    public Pepe(float x, float y, float speed, float leftBoundary, float rightBoundary) {
        this.position = new Vector2(x, y);
        this.speed = speed;
        this.isActive = true;
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }
    public void update(float delta, Cat cat) {

        Vector2 direction = new Vector2(cat.getPosition()).sub(position).nor();
        position.add(direction.scl(speed * delta));

        if (position.x < leftBoundary) position.x = leftBoundary;
        if (position.x > rightBoundary - SIZE) position.x = rightBoundary - SIZE;

    }

    private Vector2 getDirectionVector(int direction) {
        switch (direction) {
            case 0: return new Vector2(1, 0);  // Right
            case 1: return new Vector2(-1, 0); // Left
            case 2: return new Vector2(0, 1);  // Up
            case 3: return new Vector2(0, -1); // Down
            default: return new Vector2(0, 0);
        }
    }
    public Vector2 getPosition() { return position; }
    public boolean isActive() { return isActive; }
}
