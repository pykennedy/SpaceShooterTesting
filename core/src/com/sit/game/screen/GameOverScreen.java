package com.sit.game.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sit.game.MainGame;
import com.sit.game.TextureManager;

public class GameOverScreen extends Screen {

    private OrthographicCamera camera;
    private Texture texture;

    public GameOverScreen(boolean won) {
        if(won)
            texture = TextureManager.WINNER;
        else
            texture = TextureManager.LOSER;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true); // set to false to flip the display to not be mirrored
        camera.update();
    }

    @Override
    public void update() {
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, MainGame.WIDTH/2 - texture.getWidth()/2, MainGame.HEIGHT/2 - texture.getHeight()/2);
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
