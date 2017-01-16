package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.BKGND_COLOR;
import static com.ianedington.game.ud405.icicles.Constants.WORLD_SIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class IciclesScreen implements Screen {

    private ExtendViewport viewport;
    private ShapeRenderer renderer;
    private Icicle icicle;

    @Override
    public void show() {
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        icicle = new Icicle(WORLD_SIZE / 2, WORLD_SIZE / 2);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(BKGND_COLOR.r, BKGND_COLOR.g, BKGND_COLOR.b, BKGND_COLOR.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        icicle.render(renderer);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        renderer.dispose();
    }

    @Override
    public void dispose() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}
}
