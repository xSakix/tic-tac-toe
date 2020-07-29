package tic.tac.toe;

public class TicTacToeGame  {

    public static Game start(){
        return new Game() {
            @Override
            public boolean isStarted() {
                return true;
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean canAdd(GameShape shape) {
                return true;
            }

            @Override
            public void add(GameShape shape) {

            }
        };
    }
}
