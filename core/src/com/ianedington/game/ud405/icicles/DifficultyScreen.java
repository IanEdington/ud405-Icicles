package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Difficulty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class DifficultyScreen extends InputAdapter implements Screen {
    private IciclesGame game;
    private FitViewport viewport;
    private BitmapFont font;
    private SpriteBatch batch;
    private ShapeRenderer renderer;

    public DifficultyScreen(IciclesGame game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
        viewport = new FitViewport(Difficulty.WORLD_SIZE, Difficulty.WORLD_SIZE);
        font = new BitmapFont();
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(
                Difficulty.BKGND_COLOR.r,
                Difficulty.BKGND_COLOR.g,
                Difficulty.BKGND_COLOR.b,
                Difficulty.BKGND_COLOR.a);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Difficulty difficulty: Difficulty.values()) {
            renderer.setColor(difficulty.color);
            renderer.circle(difficulty.btnPosX, difficulty.btnPosY, Difficulty.BTN_RADIUS);
        }
        renderer.end();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        for (Difficulty difficulty: Difficulty.values()) {
            font.draw(batch, difficulty.toString(),
                    difficulty.btnPosX, difficulty.btnPosY,
                    0, Align.center, false);
        }
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touch = viewport.unproject(new Vector2(screenX, screenY));
        for (Difficulty difficulty: Difficulty.values()) {
            if (Vector2.dst2(difficulty.btnPosX, difficulty.btnPosY, touch.x, touch.y)
                    < Difficulty.BTN_RADIUS2) {
                game.difficulty = difficulty;
                game.showIcicleScreen();
                return true;
            }
        }
        return true;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        font.getData().setScale(Difficulty.BTN_SCALE);
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
