package tic.tac.toe;

import tic.tac.toe.UIGameShape;

import java.awt.*;

public class UIOShape extends OShape implements UIGameShape {

    UIOShape(int[] position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle selected = UITicTacToeGame.positions[row()][column()];
        g2d.drawOval(selected.x+selected.width/3,selected.y+selected.height/3,33,33);
    }
}
