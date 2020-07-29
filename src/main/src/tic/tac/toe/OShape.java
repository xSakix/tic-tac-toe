package tic.tac.toe;

import java.util.Arrays;

class OShape implements GameShape{
    private int[] position ;

    OShape(int[] position) {
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
