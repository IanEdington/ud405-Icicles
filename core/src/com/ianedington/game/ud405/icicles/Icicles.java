package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Iccl;
import static com.ianedington.game.ud405.icicles.Constants.WORLD_SIZE;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.Random;

class Icicles {
    private DelayedRemovalArray<Icicle> icicles;
    private Viewport viewport;
    private Random random;
    private float spawn = 1;

    protected Icicles(Viewport viewport) {
        this.viewport = viewport;
        icicles = new DelayedRemovalArray<Icicle>(false, 16);
        random = new Random();
    }

    protected void update(float delta) {
        icicles.begin();

        // Update existing icicles
        for (int i = 0; i < icicles.size; i++) {
            Icicle icicle = icicles.get(i);
            if (icicle.isOnScreen()) {
                icicle.update(delta);
            } else {
                icicles.removeIndex(i);
            }
        }

        // add new Icicle
        spawn += delta * Iccl.SPAWN;
        while (spawn > 1) {
            icicles.add(new Icicle(
                    random.nextFloat() * viewport.getWorldWidth(),
                    viewport.getWorldHeight()));
            spawn--;
        }

        icicles.end();
    }

    protected void render(ShapeRenderer renderer) {
        for (Icicle icicle: icicles) {
            renderer.setColor(Iccl.COLOR);
            icicle.render(renderer);
        }
    }

    protected void reset(Viewport viewport) {
        this.viewport = viewport;
    }
}
