package com.ianedington.game.ud405.icicles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class IciclesGame extends Game {
    @Override
    public void create() {
        setScreen(new IciclesScreen());
    }
}
