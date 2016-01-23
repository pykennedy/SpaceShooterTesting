package com.sit.game.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sit.game.entity.EntityManager;

public class GameScreen extends Screen {

    private OrthographicCamera camera;
    private EntityManager entityManager;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true); // set to false to flip the display to not be mirrored
        entityManager = new EntityManager(20);
    }

    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.update();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
