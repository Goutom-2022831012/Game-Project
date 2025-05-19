package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;

public class Pepe {
    private Vector2 position;
    private float speed;
    private static final float SIZE = 50;
    private float leftBoundary, rightBoundary;

    public Pepe(float x, float y, float speed, float leftBoundary, float rightBoundary) {
        this.position = new Vector2(x, y);
        this.speed = speed;
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }
    public void update(float delta, Cat cat) {

        Vector2 direction = new Vector2(cat.getPosition()).sub(position).nor();
        position.add(direction.scl(speed * delta));

        if (position.x < leftBoundary) position.x = leftBoundary;
        if (position.x > rightBoundary - SIZE) position.x = rightBoundary - SIZE;

    }
    public Vector2 getPosition() { return position; }
}
