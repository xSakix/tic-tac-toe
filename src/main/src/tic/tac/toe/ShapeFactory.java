package tic.tac.toe;

public class ShapeFactory {
    public static GameShape newOShape(final int[] pos) {
        return new OShape(pos);
    }

    public static GameShape newXShape(final int[] pos) {
        return new XShape(pos);
    }
}
