package tic.tac.toe;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;

public class GameTest{

    @Test
    public void playGameScenario(){
        Game game = TicTacToeGame.start();
        Assert.assertNotNull(game);

        //started actualy has no meaning...so lets remove it
        //Assert.assertTrue(game.isStarted());
        Assert.assertFalse(game.isFinished());

        GameShape oShape = ShapeFactory.newOShape(GridPosition.ONE);
        Assert.assertNotNull(oShape);
        Assert.assertTrue(game.canAdd(oShape));
        game.add(oShape);
        Assert.assertFalse(game.isFinished());

        GameShape xShape = ShapeFactory.newXShape(GridPosition.ONE);
        Assert.assertNotNull(xShape);
        Assert.assertFalse(game.canAdd(xShape));

        xShape = ShapeFactory.newXShape(GridPosition.TWO);
        Assert.assertNotNull(xShape);
        Assert.assertTrue(game.canAdd(xShape));
        game.add(xShape);
        Assert.assertFalse(game.isFinished());

        List<GameShape> shapesToAdd = new ArrayList<>();
        shapesToAdd.add(ShapeFactory.newXShape(GridPosition.FIVE));
        shapesToAdd.add(ShapeFactory.newXShape(GridPosition.EIGHT));
        for(GameShape shape: shapesToAdd){
            Assert.assertNotNull(shape);
            Assert.assertTrue(game.canAdd(shape));
            game.add(shape);
        }

        Assert.assertTrue(game.isFinished());
    }

    enum ShapeType{
        O,X;

        public GameShape createShape(int[] pos){
            if(this == O){
                return ShapeFactory.newOShape(pos);
            } else if (this == X) {
                return ShapeFactory.newXShape(pos);
            }
            return null;
        }
    }

    private static final int FIRST_ROW = 0;
    private static final int SECOND_ROW = 1;
    private static final int THIRD_ROW = 2;

    private static final int FIRST_COL = 0;
    private static final int SECOND_COL = 1;
    private static final int THIRD_COL = 2;

    enum WhichDiagonal{
        FROM_ONE_TO_NINE,
        FROM_THREE_TO_SEVEN;

        public int[][] positions(){
            if(this == FROM_ONE_TO_NINE){
                return new int[][]{{0,0},{1,1},{2,2}};
            }else if(this == FROM_THREE_TO_SEVEN){
                return new int[][]{{2,0},{1,1},{0,2}};
            }

            return null;
        }
    }

    @Test
    public void finishedGame(){
        emptyGrid();
        //there are 8 ways * 2 shapes to finish the game, so let's define them...
        rowFinishedOfGivenShape(FIRST_ROW,ShapeType.O);
        rowFinishedOfGivenShape(SECOND_ROW,ShapeType.O);
        rowFinishedOfGivenShape(THIRD_ROW,ShapeType.O);

        rowFinishedOfGivenShape(FIRST_ROW,ShapeType.X);
        rowFinishedOfGivenShape(SECOND_ROW,ShapeType.X);
        rowFinishedOfGivenShape(THIRD_ROW,ShapeType.X);

        colFinishedOfGivenShape(FIRST_COL,ShapeType.O);
        colFinishedOfGivenShape(SECOND_COL,ShapeType.O);
        colFinishedOfGivenShape(THIRD_COL,ShapeType.O);

        colFinishedOfGivenShape(FIRST_COL,ShapeType.X);
        colFinishedOfGivenShape(SECOND_COL,ShapeType.X);
        colFinishedOfGivenShape(THIRD_COL,ShapeType.X);

        diagonalFinishedOfGivenShape(WhichDiagonal.FROM_ONE_TO_NINE,ShapeType.O);
        diagonalFinishedOfGivenShape(WhichDiagonal.FROM_ONE_TO_NINE,ShapeType.X);

        diagonalFinishedOfGivenShape(WhichDiagonal.FROM_THREE_TO_SEVEN,ShapeType.O);
        diagonalFinishedOfGivenShape(WhichDiagonal.FROM_THREE_TO_SEVEN,ShapeType.X);


        cantAddAnyMoreShapes();
    }

    private void cantAddAnyMoreShapes() {
        //Let assume for now full grid without a line or diagonal of same shapes
        //The more correct one would be to discover that the next shape can't advance the game, but
        //thats a much harder case
        Game game = TicTacToeGame.start();

        game.add(ShapeFactory.newOShape(new int[]{0,0}));
        game.add(ShapeFactory.newOShape(new int[]{1,0}));
        game.add(ShapeFactory.newXShape(new int[]{2,0}));

        game.add(ShapeFactory.newXShape(new int[]{0,1}));
        game.add(ShapeFactory.newXShape(new int[]{1,1}));
        game.add(ShapeFactory.newOShape(new int[]{2,1}));


        game.add(ShapeFactory.newOShape(new int[]{0,2}));
        game.add(ShapeFactory.newOShape(new int[]{1,2}));
        game.add(ShapeFactory.newXShape(new int[]{2,2}));

        Assert.assertTrue(game.isFinished());
    }

    private void diagonalFinishedOfGivenShape(WhichDiagonal diagonal, ShapeType type) {
        Game game = TicTacToeGame.start();
        for(int[] coords : diagonal.positions()){
            game.add(type.createShape(coords));
        }

        Assert.assertTrue(game.isFinished());
    }

    private void colFinishedOfGivenShape(int col, ShapeType type) {
        Game game = TicTacToeGame.start();

        for(int i = 0 ; i < Game.MAX_ROW; i++){
            int[] pos = new int[]{i,col};
            game.add(type.createShape(pos));
        }

        Assert.assertTrue(game.isFinished());
    }

    private void rowFinishedOfGivenShape(int row, ShapeType type) {
        Game game = TicTacToeGame.start();

        for(int i = 0 ; i < Game.MAX_COL; i++){
            int[] pos = new int[]{row,i};
            game.add(type.createShape(pos));
        }

        Assert.assertTrue(game.isFinished());
    }

    private void emptyGrid() {
        Game game = TicTacToeGame.start();
        Assert.assertFalse(game.isFinished());
    }

}
