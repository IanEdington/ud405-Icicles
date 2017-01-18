package com.ianedington.game.ud405.icicles;

import static com.ianedington.game.ud405.icicles.Constants.Plyr;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {
    Vector2 pos;
    Viewport viewport;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    private void init() {
        pos = new Vector2(viewport.getWorldHeight() / 2, 0);
    }

    public void render(ShapeRenderer renderer) {
        Vector2 leftFoot = new Vector2(pos.x + Plyr.L_FT_X, pos.y + Plyr.L_FT_Y);
        Vector2 rightFoot = new Vector2(pos.x + Plyr.R_FT_X, pos.y + Plyr.R_FT_Y);
        Vector2 leftHand = new Vector2(pos.x + Plyr.L_HAND_X, pos.y + Plyr.L_HAND_Y);
        Vector2 rightHand = new Vector2(pos.x + Plyr.R_HAND_X, pos.y + Plyr.R_HAND_Y);
        Vector2 groin = new Vector2(pos.x + Plyr.GROIN_X, pos.y + Plyr.GROIN_Y);
        Vector2 head = new Vector2(pos.x + Plyr.HEAD_X, pos.y + Plyr.HEAD_Y);

        renderer.setColor(Plyr.COLOR);
        renderer.rectLine(leftFoot, groin, Plyr.WIDTH);
        renderer.rectLine(rightFoot, groin, Plyr.WIDTH);
        renderer.rectLine(groin, head, Plyr.WIDTH);
        renderer.rectLine(leftHand, rightHand, Plyr.WIDTH);
        renderer.circle(head.x, head.y, Plyr.HEAD_RADIUS, Plyr.HEAD_SEGMENTS);
    }
}
