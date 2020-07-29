package tic.tac.toe;

import java.util.Map;

public class TicTacToeGame  {

    public static Game start(){
        return new Game() {

            private GameShape[][] grid = new GameShape[3][3];

            @Override
            public boolean isStarted() {
                return true;
            }

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
