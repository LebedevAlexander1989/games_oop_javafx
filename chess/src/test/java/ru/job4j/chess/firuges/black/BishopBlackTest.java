package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class BishopBlackTest {

    private BishopBlack bishopBlack;

    @BeforeEach
    public void beforeEach() {
        this.bishopBlack = new BishopBlack(Cell.C1);
    }

    @Test
    public void position() {
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    public void copy() {
        Cell dest = Cell.G5;
        assertThat(bishopBlack.copy(dest).position()).isEqualTo(Cell.G5);
    }

    @Test
    public void way() {
        Cell[] way = bishopBlack.way(Cell.G5);
        assertThat(way).isEqualTo(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void whenBishopBlackWayIsNotDiagonalThenException() {
        ImpossibleMoveException ex =
                assertThrows(ImpossibleMoveException.class, () -> bishopBlack.way(Cell.D1));
        assertThat(ex.getMessage()).isEqualTo("Could not way by diagonal from C1 to D1");
    }

    @Test
    public void isDiagonalTrue() {
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), Cell.G5)).isTrue();
    }

    @Test
    public void isDiagonalFalse() {
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), Cell.G4)).isFalse();
    }
}