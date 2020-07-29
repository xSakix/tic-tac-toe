package tic.tac.toe;

public class ShapeFactory {
    public static GameShape newOShape(int[] one) {
        return new GameShape() {
            @Override
            public int row() {
                return 0;
            }

            @Override
            public int column() {
                return 0;
            }
        };
    }

    public static GameShape newXShape(int[] one) {
        return new GameShape() {
            @Override
            public int row() {
                return 0;
            }

            @Override
            public int column() {
                return 0;
            }
        };
    }
}
