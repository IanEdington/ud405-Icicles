package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.BKGND_COLOR;
import static com.ianedington.game.ud405.icicles.Constants.Hud;
import static com.ianedington.game.ud405.icicles.Constants.WORLD_SIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class IciclesScreen implements Screen {
    private ExtendViewport viewport;
    private ShapeRenderer renderer;

    private Icicles icicles;
    private Player player;
    private boolean stillPlaying;
    private int highScore;

    private SpriteBatch batch;
    private ScreenViewport hudViewport;
    private BitmapFont font;

    @Override
    public void show() {
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        icicles = new Icicles(viewport);
        player = new Player(viewport);
        stillPlaying = true;

        batch = new SpriteBatch();
        hudViewport = new ScreenViewport();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        highScore = 0;
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(BKGND_COLOR.r, BKGND_COLOR.g, BKGND_COLOR.b, BKGND_COLOR.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        if (stillPlaying) {
            player.update(delta);
            stillPlaying = icicles.update(delta, player);
        } else {
            icicles.newGame();
            stillPlaying = true;
        }

        highScore = Integer.max(icicles.getScore(), highScore);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer, !stillPlaying);
        renderer.end();

        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();
        float hudHeight = hudViewport.getWorldHeight();
        float hudWidth = hudViewport.getWorldWidth();
        String message = String.format("Player Deaths: %d", player.getDeaths());
        font.draw(batch, message, Hud.MARGIN, hudHeight - Hud.MARGIN);
        message = String.format("Score: %d\nHigh Score: %d", icicles.getScore(), highScore);
        font.draw(batch, message, hudWidth - 100, hudHeight - 40);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        player.reset(viewport);
        icicles.reset(viewport);

        hudViewport.update(width, height, true);
        font.getData().setScale(Float.min(width, height) / (5 * WORLD_SIZE));
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
        font.dispose();
    }

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}
}
