package tic.tac.toe;

import java.awt.*;

public class UIXShape extends XShape implements UIGameShape {

    UIXShape(int[] position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle selected = UITicTacToeGame.positions[row()][column()];
        g2d.drawLine(selected.x+selected.width/3,selected.y+selected.height/3,selected.x+2*selected.width/3,selected.y+2*selected.height/3);
        g2d.drawLine(selected.x+2*selected.width/3,selected.y+selected.height/3,selected.x+selected.width/3,selected.y+2*selected.height/3);
    }
}
