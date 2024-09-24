package ru.job4j.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class LogicTest {

    private Logic logic;

    @BeforeEach
    public void beforeEach() {
        this.logic = new Logic();
    }

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws ImpossibleMoveException {
        FigureNotFoundException exception =
                assertThrows(FigureNotFoundException.class,  () -> logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws ImpossibleMoveException {
        Cell source = Cell.B8;
        Cell dest = Cell.D6;
        Figure bishopBlack = new BishopBlack(source);
        Figure kingBlack = new KingBlack(Cell.C7);
        logic.add(bishopBlack);
        logic.add(kingBlack);
        OccupiedCellException ex =
                assertThrows(OccupiedCellException.class, () -> logic.move(source, dest));
        assertThat(ex.getMessage()).isEqualTo("Cell is occupied");
    }
}