package pl.sdacademy.cnc;

public interface CNCGame {
    void start();

    boolean hasFinished();

    Player switchTurn();

    void applyMove(Element element);

    void restart();
}
