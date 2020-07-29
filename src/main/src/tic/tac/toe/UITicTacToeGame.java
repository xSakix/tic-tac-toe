package tic.tac.toe;

import java.awt.*;

public class UITicTacToeGame extends TicTacToeGame implements UIGame {


    public static final Rectangle[][] positions = new Rectangle[Game.MAX_ROW][Game.MAX_COL];
    /**
     * 0,0 = 0,0,100,100
     * 0,1 = 100,0,200,100
     * 0,2 = 200,0,300,100
     * 1,0 = 0,100,100,200
     * 1,1 = 100,100,200,200
     * 1,2 = 200,100,300,200
     * 2,0 = 0,200,0,300
     * 2,1 = 100,200,100,300
     * 2,2 = 200,200,300,300
     */

    {
        positions[0][0] = new Rectangle(0,0,100,100);
        positions[0][1] = new Rectangle(100,0,100,100);
        positions[0][2] = new Rectangle(200,0,100,100);

        positions[1][0] = new Rectangle(0,100,100,100);
        positions[1][1] = new Rectangle(100,100,100,100);
        positions[1][2] = new Rectangle(200,100,100,100);

        positions[2][0] = new Rectangle(0,200,100,100);
        positions[2][1] = new Rectangle(100,200,100,100);
        positions[2][2] = new Rectangle(200,200,100,100);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for(int row = 0; row < MAX_ROW;row++){
            for (int col = 0; col < MAX_COL;col++){
                GameShape shape = grid[row][col];
                if( shape != null){
                    if(shape instanceof OShape){
                        UIOShape uioShape = new UIOShape(new int[]{shape.row(),shape.column()});
                        uioShape.draw(g2d);
                    }else if(shape instanceof XShape){
                        UIXShape uixShape = new UIXShape(new int[]{shape.row(),shape.column()});
                        uixShape.draw(g2d);
                    }
                }
            }
        }
    }

    public static UIGame start() {
        return new UITicTacToeGame();
    }
}
