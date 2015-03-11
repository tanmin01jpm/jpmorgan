package uk.co.mint.sudoku.service;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.mint.sudoku.datamodel.SudokuBoard;
import uk.co.mint.sudoku.datamodel.ValidationType;

@RunWith(MockitoJUnitRunner.class)
public class BoardServiceImplIntegerationTest {

	@Test
	public void test() {
		List<String> rows = new LinkedList<String>();
		for (int i = 0; i < SudokuBoard.AREA_SIZE; i++) {
			rows.add("1,2,3,4,5,6,7,8,9");
		}

		BoardService tested = new BoardServiceImpl();
		SudokuBoard sudokuBoard = tested.constructSudokuBoard(rows);
		assertTrue(sudokuBoard.getAreas(ValidationType.COLUMN).size() == SudokuBoard.AREA_SIZE);
		assertTrue(sudokuBoard.getAreas(ValidationType.ROW).size() == SudokuBoard.AREA_SIZE);
		assertTrue(sudokuBoard.getAreas(ValidationType.SQUARE).size() == SudokuBoard.AREA_SIZE);
	}
}
