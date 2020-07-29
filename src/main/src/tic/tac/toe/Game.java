package tic.tac.toe;

public interface Game {
    boolean isStarted();

    boolean isFinished();

    boolean canAdd(GameShape shape);

    void add(GameShape shape);
}
