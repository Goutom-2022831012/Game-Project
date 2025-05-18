package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import java.util.List;
import com.badlogic.gdx.math.Rectangle;


public class Cat {
    private Vector2 position;
    private float speed;
    private float size;
    private int direction;
    private Vector2 initialPosition;
    public boolean gameOver = false;

    public Cat(float x, float y, float size) {
        this.position = new Vector2(x, y);
        this.speed = 150;
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
            gameOver = true;
        }

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        position.x = Math.max(0, Math.min(position.x, screenWidth - size));
        position.y = Math.max(0, Math.min(position.y, screenHeight - size));
    }
    private boolean isColliding(Vector2 newPos, List<Wall> walls) {
        Rectangle catBounds = new Rectangle(newPos.x, newPos.y, size, size);
        for (Wall wall : walls) {
            if (catBounds.overlaps(wall.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public void moveRight() { direction = 0; }
    public void moveLeft() { direction = 1; }
    public void moveUp() { direction = 2; }
    public void moveDown() { direction = 3; }
    public int getDirection() {return direction;}
    public Vector2 getPosition() { return position; }
    public float getSize() { return size; }
}
