package com.ianedington.game.ud405.icicles;

import com.badlogic.gdx.graphics.Color;

final class Constants {
    public static float WORLD_SIZE = 100;
    public static Color BKGND_COLOR = Color.BLUE;

    // the hud
    public static final class Hud {
        public static float MARGIN = 10;
        public static float FONT_PROPORTION = 480;
    }

    // Icicle constants
    public static final class Iccl {
        public static float HEIGHT = 10;
        public static float WIDTH = 2;
        public static float ACCEL = 0.05f;
        public static Color COLOR = Color.WHITE;
    }

    // Character constants relative to left foot.
    public static final class Plyr {
        public static Color COLOR = Color.BLACK;
        public static Color END_COLOR = Color.RED;
        public static float SCALE = 5;
        public static float SPEED = SCALE * 10;
        public static float LINE_WIDTH = SCALE / 4;
        public static float L_FT_X = -SCALE;
        public static float L_FT_Y = 0;
        public static float R_FT_X = L_FT_X + SCALE * 2;
        public static float R_FT_Y = L_FT_Y;
        public static float GROIN_X = L_FT_X + SCALE;
        public static float GROIN_Y = L_FT_Y + SCALE;
        public static float L_HAND_X = L_FT_X;
        public static float L_HAND_Y = L_FT_Y + SCALE * 4;
        public static float R_HAND_X = L_FT_X + SCALE * 2;
        public static float R_HAND_Y = L_FT_Y + SCALE * 4;
        public static float HEAD_X = L_FT_X + SCALE;
        public static float HEAD_Y = L_FT_Y + SCALE * 6;
        public static float HEAD_RADIUS = SCALE;
        public static float HEAD_RADIUS2 = HEAD_RADIUS * HEAD_RADIUS;
        public static int HEAD_SEGMENTS = (int) (SCALE * HEAD_RADIUS);
        public static float BODY_WIDTH = R_FT_X - L_FT_X;
    }

    public enum Difficulty {
        COLD(8, Color.BLUE, 50, 150),
        COLDER(12, Color.CYAN, 150, 150),
        COLDEST(18, Color.DARK_GRAY, 250, 150);

        public static float WORLD_SIZE = 300;
        public static Color BKGND_COLOR = Color.BLACK;
        public static float BTN_RADIUS = 40;
        public static float BTN_RADIUS2 = BTN_RADIUS * BTN_RADIUS;
        public static float BTN_SCALE = 1f;

        public float spawnRate; // in meters
        public Color color; // in meters
        public float btnPosX;
        public float btnPosY;

        Difficulty(float spawnRate, Color color, float x, float y) {
            this.spawnRate = spawnRate;
            this.color = color;
            this.btnPosX = x;
            this.btnPosY = y;
        }
    }
}
