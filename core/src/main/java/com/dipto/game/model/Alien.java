package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class Alien {
    private Vector2 position;
    private float speed;
    private boolean isActive;
    private static final float SIZE = 20;

    public Alien(float x, float y, float speed) {
        this.position = new Vector2(x, y);
        this.speed = speed;
        this.isActive = true;
    }

    public void update(float delta, Pacman pacman) {
        if (!isActive) return;

        Vector2 direction = new Vector2(pacman.getPosition()).sub(position).nor();
        position.add(direction.scl(speed * delta));

        if (isEatenByPacman(pacman)) {
            isActive = false;  // Disappear
        }
    }

    private boolean isEatenByPacman(Pacman pacman) {
        Vector2 pacmanPos = pacman.getPosition();
        Rectangle pacmanBounds = new Rectangle(pacmanPos.x, pacmanPos.y, pacman.getSize(), pacman.getSize());
        Rectangle alienBounds = new Rectangle(position.x, position.y, SIZE, SIZE);

        if (pacmanBounds.overlaps(alienBounds)) {
            // Check if Pac-Man is behind the Alien
            Vector2 pacmanDir = getDirectionVector(pacman.getDirection());
            Vector2 alienToPacman = new Vector2(pacmanPos).sub(position).nor();

            if (pacmanDir.dot(alienToPacman) > 0.8f) {
                return true;
            }
        }
        return false;
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
