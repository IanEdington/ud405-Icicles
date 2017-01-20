package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Plyr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {
    Vector2 pos;
    Viewport viewport;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        pos = new Vector2(viewport.getWorldHeight() / 2, 0);
    }

    protected void update(float delta) {
        boolean moveLeft = Gdx.input.isKeyPressed(Keys.LEFT);
        boolean moveRight = Gdx.input.isKeyPressed(Keys.RIGHT);

        if (moveLeft) {
            pos.x -= Plyr.SPEED * delta;
        }

        if (moveRight) {
            pos.x += Plyr.SPEED * delta;
        }

        // ensure player is in bounds
        pos.x = Float.min(
                Float.max(pos.x, Plyr.BODY_WIDTH / 2),
                viewport.getWorldWidth() - Plyr.BODY_WIDTH / 2);
    }

    public void render(ShapeRenderer renderer, boolean playerDied) {
        Vector2 leftFoot = new Vector2(pos.x + Plyr.L_FT_X, pos.y + Plyr.L_FT_Y);
        Vector2 rightFoot = new Vector2(pos.x + Plyr.R_FT_X, pos.y + Plyr.R_FT_Y);
        Vector2 leftHand = new Vector2(pos.x + Plyr.L_HAND_X, pos.y + Plyr.L_HAND_Y);
        Vector2 rightHand = new Vector2(pos.x + Plyr.R_HAND_X, pos.y + Plyr.R_HAND_Y);
        Vector2 groin = new Vector2(pos.x + Plyr.GROIN_X, pos.y + Plyr.GROIN_Y);
        Vector2 head = new Vector2(pos.x + Plyr.HEAD_X, pos.y + Plyr.HEAD_Y);

        renderer.setColor(Plyr.COLOR);
        renderer.rectLine(leftFoot, groin, Plyr.LINE_WIDTH);
        renderer.rectLine(rightFoot, groin, Plyr.LINE_WIDTH);
        renderer.rectLine(groin, head, Plyr.LINE_WIDTH);
        renderer.rectLine(leftHand, rightHand, Plyr.LINE_WIDTH);
        if (playerDied) {
            renderer.setColor(Plyr.END_COLOR);
        }
        renderer.circle(head.x, head.y, Plyr.HEAD_RADIUS, Plyr.HEAD_SEGMENTS);
    }

    protected boolean contact(Vector2 iciclePos) {
        return iciclePos.dst2(pos.x + Plyr.HEAD_X, pos.y + Plyr.HEAD_Y) < Plyr.HEAD_RADIUS2;
    }
}
