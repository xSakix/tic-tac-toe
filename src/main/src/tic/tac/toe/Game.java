package tic.tac.toe;

public interface Game {

    int MAX_ROW = 3;
    int MAX_COL = 3;

    boolean isFinished();

    boolean canAdd(GameShape shape);

    void add(GameShape shape);

    boolean isGridFull();

    boolean isLine();
}
