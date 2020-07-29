package tic.tac.toe;

import org.junit.Assert;
import org.junit.Test;

public class GameShapeTest {

    @Test
    public void position(){
        GameShape shape = ShapeFactory.newXShape(GridPosition.ONE);
        Assert.assertNotNull(shape);
        Assert.assertEquals(shape.row(), GridPosition.ONE[GridPosition.ROW]);
        Assert.assertEquals(shape.column(), GridPosition.ONE[GridPosition.COL]);
    }
}
