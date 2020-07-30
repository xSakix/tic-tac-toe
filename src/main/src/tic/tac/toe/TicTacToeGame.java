package tic.tac.toe;

import java.util.Arrays;

public class TicTacToeGame implements Game {

    protected GameShape[][] grid = new GameShape[MAX_ROW][MAX_COL];

    TicTacToeGame() {
    }

    @Override
    public boolean isFinished() {

        if (checkRows()) return true;
        if (checkCols()) return true;
        if(checkLeftToRightDiagonal()) return true;
        if(checkRightToLeftDiagonal()) return true;
        if(gridFull()) return true;

        return false;
    }

    private boolean gridFull() {
        for (int row = 0; row < Game.MAX_ROW;row++){
            for(int col = 0; col < Game.MAX_COL;col++){
                if(grid[row][col] == null){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRightToLeftDiagonal() {
        int[][] diag = new int[][]{{2, 0}, {1, 1}, {0, 2}};
        int count_o = 0;
        int count_x = 0;
        for (int[] coord : diag) {
            if (isEmptySlot(grid[coord[0]][coord[1]])) {
                break;
            }

            if (grid[coord[0]][coord[1]] instanceof OShape) {
                count_o++;
            } else if (grid[coord[0]][coord[1]] instanceof XShape) {
                count_x++;
            }
            if (count_o == 3 || count_x == 3) {
                return true;
            }

        }
        return false;
    }

    private boolean checkLeftToRightDiagonal() {
        int[][] diag = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        int count_o = 0;
        int count_x = 0;

        for (int[] coord : diag) {
            if (isEmptySlot(grid[coord[0]][coord[1]])) {
                break;
            }

            if (grid[coord[0]][coord[1]] instanceof OShape) {
                count_o++;
            } else if (grid[coord[0]][coord[1]] instanceof XShape) {
                count_x++;
            }
            if (count_o == 3 || count_x == 3) {
                return true;
            }

        }

        return false;
    }

    private boolean checkCols() {
        for (int col = 0; col < MAX_COL; col++) {
            int count_o = 0;
            int count_x = 0;
            for (int row = 0; row < MAX_ROW; row++) {
                if (isEmptySlot(grid[row][col])) {
                    break;
                }

                if (grid[row][col] instanceof OShape) {
                    count_o++;
                } else if (grid[row][col] instanceof XShape) {
                    count_x++;
                }
            }

            if (count_o == 3 || count_x == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        for (int row = 0; row < MAX_ROW; row++) {
            int count_o = 0;
            int count_x = 0;
            for (int col = 0; col < MAX_COL; col++) {
                if (isEmptySlot(grid[row][col])) {
                    break;
                }

                if (grid[row][col] instanceof OShape) {
                    count_o++;
                } else if (grid[row][col] instanceof XShape) {
                    count_x++;
                }
            }

            if (count_o == 3 || count_x == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmptySlot(GameShape gameShape) {
        return gameShape == null;
    }

    @Override
    public boolean canAdd(GameShape shape) {

        return isEmptySlot(grid[shape.row()][shape.column()]);
    }

    @Override
    public void add(GameShape shape) {
        grid[shape.row()][shape.column()] = shape;
    }

    @Override
    public boolean isGridFull() {
        return gridFull();
    }

    @Override
    public boolean isLine() {
        return checkRows() || checkCols() || checkLeftToRightDiagonal() || checkRightToLeftDiagonal();
    }


    public static Game start() {
        return new TicTacToeGame();
    }
}
