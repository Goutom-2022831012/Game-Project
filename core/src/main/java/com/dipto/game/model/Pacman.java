package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;


public class Pacman {
    private Vector2 position;
    private float speed;
    private float size;
    private int direction;

    public Pacman(float x, float y, float size) {
        this.position = new Vector2(x, y);
        this.speed = 100;
        this.size = size;
        this.direction = 0;
    }

    public void update(float delta) {
        switch (direction) {
            case 0: position.x += speed * delta; break; // Right
            case 1: position.x -= speed * delta; break; // Left
            case 2: position.y += speed * delta; break; // Up
            case 3: position.y -= speed * delta; break; // Down
        }
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        position.x = Math.max(0, Math.min(position.x, screenWidth - size));
        position.y = Math.max(0, Math.min(position.y, screenHeight - size));
    }


    public void moveRight() { direction = 0; }
    public void moveLeft() { direction = 1; }
    public void moveUp() { direction = 2; }
    public void moveDown() { direction = 3; }

    public Vector2 getPosition() { return position; }
    public float getSize() { return size; }
}
