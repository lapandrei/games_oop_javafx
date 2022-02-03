package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        BishopBlack obj = new BishopBlack(Cell.F8);
        Assert.assertEquals(Cell.F8, obj.position());
    }

    @Test
    public void copyTest() {
        Figure obj = new BishopBlack(Cell.A1);
        obj = obj.copy(Cell.B3);

        Assert.assertEquals(Cell.B3, obj.position());
    }

    @Test
    public void wayReturnRightMassiveSteps() {
        BishopBlack obj = new BishopBlack(Cell.C1);
        Cell[] steps = obj.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, steps);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void wayIsNotDiagonal() {
        BishopBlack obj = new BishopBlack(Cell.C1);
        Cell[] steps = obj.way(Cell.E5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, steps);
    }
}