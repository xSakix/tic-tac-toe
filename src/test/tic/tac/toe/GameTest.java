package tic.tac.toe;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class GameTest{

    @Test
    public void playGameScenario(){
        Game game = TicTacToeGame.start();
        Assert.assertNotNull(game);
        Assert.assertTrue(game.isStarted());
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
        shapesToAdd.add(ShapeFactory.newXShape(GridPosition.FOUR));
        shapesToAdd.add(ShapeFactory.newXShape(GridPosition.SEVEN));
        for(GameShape shape: shapesToAdd){
            Assert.assertNotNull(shape);
            Assert.assertTrue(game.canAdd(shape));
        }

        //what does it mean that the game is finished?
        Assert.assertTrue(game.isFinished());
    }

}
