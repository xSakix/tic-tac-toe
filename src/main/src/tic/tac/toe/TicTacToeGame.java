package tic.tac.toe;

import java.util.Map;

public class TicTacToeGame  {

    public static Game start(){
        return new Game() {

            private GameShape[][] grid = new GameShape[MAX_ROW][MAX_COL];

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean canAdd(GameShape shape) {

                return grid[shape.row()][shape.column()] == null;
            }

            @Override
            public void add(GameShape shape) {
                grid[shape.row()][shape.column()] = shape;
            }
        };
    }
}
