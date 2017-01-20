package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Iccl;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Icicle {
    private Vector2 pos;
    private Vector2 vel;

    public Icicle (float x, float y) {
        pos = new Vector2(x, y);
        vel = new Vector2(0, 0);
    }

    protected void update(float delta) {
        vel.y += Iccl.ACCEL;
        pos.y -= vel.y;
    }

    public void render (ShapeRenderer renderer) {
        renderer.setColor(Iccl.COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.triangle(pos.x, pos.y,
                          pos.x + Iccl.WIDTH, pos.y + Iccl.HEIGHT,
                          pos.x - Iccl.WIDTH, pos.y + Iccl.HEIGHT);
    }

    protected boolean isOnScreen() {
        if (pos.y < 0) return false;
        return true;
    }
}
