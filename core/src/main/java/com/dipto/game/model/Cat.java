package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import java.util.List;
import com.badlogic.gdx.math.Rectangle;


public class Cat extends Charecter{

    private float size;
    private int direction;

    public Cat(float x, float y, float size) {
        this.position = new Vector2(x, y);
        this.speed = 150;
        this.size = size;
        this.direction = 0;
    }

    public void update(float delta, List<Wall> walls) {
        super.update();
        Vector2 newPosition = new Vector2(position);

        switch (direction) {
            case 0: newPosition.x += speed * delta; break; // Right
            case 1: newPosition.x -= speed * delta; break; // Left
            case 2: newPosition.y += speed * delta; break; // Up
            case 3: newPosition.y -= speed * delta; break; // Down
        }

        if (!isColliding(newPosition, walls)) {
            position.set(newPosition);
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
    public Vector2 getPosition() { return super.getPosition(); }
    public float getSize() { return size; }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
    }

    @Override
    public void setSpeed(float speed) {
        super.setSpeed(speed);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
