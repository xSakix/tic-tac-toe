package tic.tac.toe;

public class ShapeFactory {
    public static GameShape newOShape(final int[] pos) {
        return new GameShape() {

            private int[] position = pos;

            @Override
            public int row() {
                return position[GridPosition.ROW];
            }

            @Override
            public int column() {
                return position[GridPosition.COL];
            }
        };
    }

    public static GameShape newXShape(final int[] pos) {
        return new GameShape() {

            private int[] position = pos;

            @Override
            public int row() {
                return position[GridPosition.ROW];
            }

            @Override
            public int column() {
                return position[GridPosition.COL];
            }
        };
    }
}
