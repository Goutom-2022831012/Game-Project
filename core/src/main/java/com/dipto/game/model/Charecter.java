package com.dipto.game.model;

import com.badlogic.gdx.math.Vector2;

abstract public class Charecter {
    Vector2 position;
    float speed;
    public Vector2 getPosition() { return this.position; }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public void update(){

    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
