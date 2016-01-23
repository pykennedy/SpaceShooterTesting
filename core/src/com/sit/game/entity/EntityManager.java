package com.sit.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sit.game.MainGame;
import com.sit.game.TextureManager;
import com.sit.game.screen.GameOverScreen;
import com.sit.game.screen.ScreenManager;

public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;

    public EntityManager(int amount) {
        player = new Player(new Vector2(MainGame.WIDTH/2, MainGame.HEIGHT - 100), new Vector2(0,0), this);
        for (int i = 0; i < amount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(0, MainGame.HEIGHT*3);
            float speed = MathUtils.random(4, 8);
            addEntity(new Enemy(new Vector2(x, -y), new Vector2(0, speed)));
        }
    }

    public void update() {
        for (Entity e: entities)
            e.update();
        for (Missile m : getMissiles()) {
            if (m.checkEnd())
                entities.removeValue(m, false);
        }
        player.update();
        checkCollisions();
    }

    public void render(SpriteBatch sb) {
        for (Entity e: entities)
            e.render(sb);
        player.render(sb);
    }

    private void checkCollisions() {
        for (Enemy e : getEnemies()) {
            for (Missile m : getMissiles()) {
                if(e.getBounds().overlaps((m.getBounds()))) {
                    entities.removeValue(e, false);
                    entities.removeValue(m, false);
                    if(gameOver())
                        ScreenManager.setScreen((new GameOverScreen(true)));
                }
            }
            if(e.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen((new GameOverScreen(false)));
            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    private Array<Enemy> getEnemies() {
        Array<Enemy> ret = new Array<Enemy>();
        for(Entity e : entities)
            if (e instanceof Enemy)
                ret.add((Enemy)e);
        return ret;
    }

    private Array<Missile> getMissiles() {
        Array<Missile> ret = new Array<Missile>();
        for(Entity e : entities)
            if (e instanceof Missile)
                ret.add((Missile)e);
        return ret;
    }

    public boolean gameOver() {
        return getEnemies().size <=0;
    }
}
