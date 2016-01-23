package com.sit.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.sit.game.MainGame;
import com.sit.game.TextureManager;

public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFired;

    public Player(Vector2 pos, Vector2 direction, EntityManager entityManger) {
        super(TextureManager.PLAYER, pos, direction);
        this.entityManager = entityManger;
    }

    @Override
    public void update() {
        float accelX = Gdx.input.getAccelerometerY(); // inverted because landscape mode
        pos.add(direction);
        if(accelX < -0.35) { // left
            if (pos.x > 0)
                setDirection(-1000, 0);
            else
                setDirection(0, 0);
        }
        else if(accelX > 0.35) { // right
            if(pos.x + TextureManager.PLAYER.getWidth() < MainGame.WIDTH)
                setDirection(1000, 0);
            else
                setDirection(0,0);
        }
        else
            setDirection(0,0);

        if(Gdx.input.isTouched()) {
            if(System.currentTimeMillis() - lastFired >= 125) {
                entityManager.addEntity(new Missile(pos.cpy().add(
                        TextureManager.PLAYER.getWidth()/2, TextureManager.PLAYER.getHeight())));
                lastFired = System.currentTimeMillis();
            }
        }
    }
}
