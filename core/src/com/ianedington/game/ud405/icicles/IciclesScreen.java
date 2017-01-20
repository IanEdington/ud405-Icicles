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
    private Icicles icicles;
    private Player player;

    @Override
    public void show() {
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        icicles = new Icicles(viewport);
        player = new Player(viewport);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(BKGND_COLOR.r, BKGND_COLOR.g, BKGND_COLOR.b, BKGND_COLOR.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        icicles.update(delta);
        player.update(delta);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        player = new Player(viewport);
        icicles.reset(viewport);
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
