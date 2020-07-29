package tic.tac.toe;

public interface Game {

    static final int MAX_ROW = 3;
    static final int MAX_COL = 3;

    boolean isFinished();

    boolean canAdd(GameShape shape);

    void add(GameShape shape);
}
