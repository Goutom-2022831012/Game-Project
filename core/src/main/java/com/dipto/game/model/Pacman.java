package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
    private Vector2 position;
    private float speed;
    private float size;
    private int direction; // 0 = Right, 1 = Left, 2 = Up, 3 = Down

    public Pacman(float x, float y, float size) {
        this.position = new Vector2(x, y);
        this.speed = 100;
        this.size = size;
        this.direction = 0; // Default: Moving Right
    }

    public void update(float delta) {
        switch (direction) {
            case 0: position.x += speed * delta; break; // Right
            case 1: position.x -= speed * delta; break; // Left
            case 2: position.y += speed * delta; break; // Up
            case 3: position.y -= speed * delta; break; // Down
        }
    }

    public void moveRight() { direction = 0; }
    public void moveLeft() { direction = 1; }
    public void moveUp() { direction = 2; }
    public void moveDown() { direction = 3; }

    public Vector2 getPosition() { return position; }
    public float getSize() { return size; }
}
