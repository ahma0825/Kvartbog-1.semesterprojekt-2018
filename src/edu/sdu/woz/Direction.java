package edu.sdu.woz;

import java.awt.*;

public enum Direction {
    NORTH(new Point(0, 1)),
    EAST(new Point(1, 0)),
    WEST(new Point(-1, 0)),
    SOUTH(new Point(0, -1)),
    UP(new Point(0, 1)),
    DOWN(new Point(0, -1));

    private final Point delta;

    Direction(Point delta) {
        this.delta = delta;
    }

    public Point getDelta() {
        return delta;
    }

}
