package com.sit.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
    public static final Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static final Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
    public static final Texture MISSILE = new Texture(Gdx.files.internal("bullet.png"));
    public static final Texture LOSER = new Texture(Gdx.files.internal("Loser.jpg"));
    public static final Texture WINNER = new Texture(Gdx.files.internal("winner-winner.jpg"));
}
