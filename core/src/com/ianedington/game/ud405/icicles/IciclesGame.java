package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Difficulty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class IciclesGame extends Game {
    Difficulty difficulty = Difficulty.COLDEST;

    @Override
    public void create() {
        setScreen(new IciclesScreen(difficulty));
    }
}
