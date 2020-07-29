package tic.tac.toe;

import java.util.Map;

public class TicTacToeGame  {

    public static Game start(){
        return new Game() {

            private GameShape[][] grid = new GameShape[MAX_ROW][MAX_COL];

            @Override
            public boolean isFinished() {

                for(int row = 0; row < MAX_ROW; row++){
                    int count_o = 0;
                    int count_x = 0;
                    for(int col = 0; col < MAX_COL;col++){
                        if(isEmptySlot(grid[row][col])){
                           break;
                        }

                        if(grid[row][col] instanceof OShape){
                            count_o++;
                        }else if(grid[row][col] instanceof XShape){
                            count_x++;
                        }
                    }

                    if(count_o == 3 || count_x == 3){
                        return true;
                    }
                }

                for(int col = 0; col < MAX_COL;col++){
                    int count_o = 0;
                    int count_x = 0;
                    for(int row = 0; row < MAX_ROW; row++){
                        if(isEmptySlot(grid[row][col])){
                            break;
                        }

                        if(grid[row][col] instanceof OShape){
                            count_o++;
                        }else if(grid[row][col] instanceof XShape){
                            count_x++;
                        }
                    }

                    if(count_o == 3 || count_x == 3){
                        return true;
                    }
                }

                int[][] diag  = new int[][]{{0,0},{1,1},{2,2}};
                int count_o = 0;
                int count_x = 0;
                for(int[] coord : diag){
                    if(isEmptySlot(grid[coord[0]][coord[1]])){
                        break;
                    }

                    if(grid[coord[0]][coord[1]] instanceof OShape){
                        count_o++;
                    }else if(grid[coord[0]][coord[1]] instanceof XShape){
                        count_x++;
                    }
                    if(count_o == 3 || count_x == 3){
                        return true;
                    }

                }

                diag  = new int[][]{{2,0},{1,1},{0,2}};
                count_o = 0;
                count_x = 0;
                for(int[] coord : diag){
                    if(isEmptySlot(grid[coord[0]][coord[1]])){
                        break;
                    }

                    if(grid[coord[0]][coord[1]] instanceof OShape){
                        count_o++;
                    }else if(grid[coord[0]][coord[1]] instanceof XShape){
                        count_x++;
                    }
                    if(count_o == 3 || count_x == 3){
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
        };
    }
}
