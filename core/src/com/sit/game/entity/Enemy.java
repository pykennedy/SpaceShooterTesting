package com.sit.game.entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.sit.game.MainGame;
import com.sit.game.TextureManager;

public class Enemy extends Entity {

    public Enemy(Vector2 pos, Vector2 direction) {
        super(TextureManager.ENEMY, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);

        if(pos.y > MainGame.HEIGHT) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
            pos.set(x, -MainGame.HEIGHT);
        }
    }
}
