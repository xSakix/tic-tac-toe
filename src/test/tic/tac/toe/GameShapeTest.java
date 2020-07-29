package tic.tac.toe;

import org.junit.Assert;
import org.junit.Test;

public class GameShapeTest {

    @Test
    public void position(){
        assertEquals(ShapeFactory.newXShape(GridPosition.ONE),GridPosition.ONE);
        assertEquals(ShapeFactory.newXShape(GridPosition.TWO),GridPosition.TWO);
        assertEquals(ShapeFactory.newXShape(GridPosition.FOUR),GridPosition.FOUR);
        assertEquals(ShapeFactory.newXShape(GridPosition.SEVEN),GridPosition.SEVEN);
    }

    private void assertEquals(GameShape shape, int[] expectedPosition){
        Assert.assertEquals(expectedPosition[GridPosition.ROW],shape.row());
        Assert.assertEquals(expectedPosition[GridPosition.COL],shape.column());
    }

}
