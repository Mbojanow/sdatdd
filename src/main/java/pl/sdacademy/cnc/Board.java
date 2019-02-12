package pl.sdacademy.cnc;

public interface Board {

    void printState();

    String getStateString();

    void putElement(Element element);

    Element getElement(Position position);

    boolean isEmpty();

    boolean isFull();

    boolean hasLineWithAnyElements();

    boolean hasLine(Element element);
}
