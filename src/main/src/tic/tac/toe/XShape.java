package tic.tac.toe;

import java.util.Arrays;

class XShape implements GameShape{
    private int[] position ;

    XShape(int[] position) {
        this.position = Arrays.copyOf(position,position.length);
    }

    @Override
    public int row() {
        return position[GridPosition.ROW];
    }

    @Override
    public int column() {
        return position[GridPosition.COL];
    }
}
