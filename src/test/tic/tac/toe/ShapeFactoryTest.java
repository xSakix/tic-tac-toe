package tic.tac.toe;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTest {

    @Test
    public void createOShape(){
        GameShape shape = ShapeFactory.newOShape(GridPosition.ONE);
        Assert.assertTrue(shape instanceof OShape);
    }

    @Test
    public void createXShape(){
        GameShape shape = ShapeFactory.newXShape(GridPosition.ONE);
        Assert.assertTrue(shape instanceof XShape);
    }
}
