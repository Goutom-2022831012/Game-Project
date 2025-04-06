package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import java.util.List;
import com.badlogic.gdx.math.Rectangle;


public class Pacman {
    private Vector2 position;
    private float speed;
    private float size;
    private int direction;
    private Vector2 initialPosition;

    public Pacman(float x, float y, float size) {
        this.position = new Vector2(x, y);
        this.speed = 100;
        this.initialPosition = new Vector2(x, y);
        this.size = size;
        this.direction = 0;
    }

    public void update(float delta, List<Wall> walls) {
        Vector2 newPosition = new Vector2(position);

        switch (direction) {
            case 0: newPosition.x += speed * delta; break; // Right
            case 1: newPosition.x -= speed * delta; break; // Left
            case 2: newPosition.y += speed * delta; break; // Up
            case 3: newPosition.y -= speed * delta; break; // Down
        }

        if (!isColliding(newPosition, walls)) {
            position.set(newPosition);
        } else {
            resetPosition();
        }

    float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        position.x = Math.max(0, Math.min(position.x, screenWidth - size));
        position.y = Math.max(0, Math.min(position.y, screenHeight - size));
    }
    private boolean isColliding(Vector2 newPos, List<Wall> walls) {
        Rectangle pacmanBounds = new Rectangle(newPos.x, newPos.y, size, size);
        for (Wall wall : walls) {
            if (pacmanBounds.overlaps(wall.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public void resetPosition() {
        position.set(initialPosition);
        direction = 0; // Stop movement
    }

    public void moveRight() { direction = 0; }
    public void moveLeft() { direction = 1; }
    public void moveUp() { direction = 2; }
    public void moveDown() { direction = 3; }
    public int getDirection() {return direction;}
    public Vector2 getPosition() { return position; }
    public float getSize() { return size; }
}
