package pl.sdacademy.cnc;

public interface Element {
    Type getType();
    Position getPosition();

    void setType(Type type);
    void setPosition(Position position);
}
