package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Difficulty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class IciclesGame extends Game {
    protected Difficulty difficulty = Difficulty.COLD;

    @Override
    public void create() {
        setScreen(new DifficultyScreen(this));
    }

    protected void showDifficultyScreen() {
        setScreen(new DifficultyScreen(this));
    }

    protected void showIcicleScreen() {
        setScreen(new IciclesScreen(this));
    }
}
