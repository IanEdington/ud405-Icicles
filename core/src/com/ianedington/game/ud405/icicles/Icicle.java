package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.ICICLE_COLOR;
import static com.ianedington.game.ud405.icicles.Constants.ICICLE_HEIGHT;
import static com.ianedington.game.ud405.icicles.Constants.ICICLE_WIDTH;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Icicle {
    private Vector2 pos;

    public Icicle (float x, float y) {
        pos = new Vector2(x, y);
    }

    public void render (ShapeRenderer renderer) {
        renderer.setColor(ICICLE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.triangle(
                pos.x,
                pos.y,
                pos.x + ICICLE_WIDTH,
                pos.y + ICICLE_HEIGHT,
                pos.x - ICICLE_WIDTH,
                pos.y + ICICLE_HEIGHT);
    }
}
