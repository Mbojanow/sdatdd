package pl.sdacademy.cnc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardTest {

    private Board board;

    @Test
    void shouldPrintStateWithSingleElement() {
        Element element = new CNCElement();
        element.setType(Type.CIRCLE);
        element.setPosition(new PositionImpl(2, 3));
        board.putElement(element);

        final String actual = board.getStateString();

        assertThat(actual).isEqualTo("_ _ _\n_ _ _\n_ X _");
    }
}