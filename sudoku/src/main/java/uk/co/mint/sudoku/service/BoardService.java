package uk.co.mint.sudoku.service;

import java.util.List;

import uk.co.mint.sudoku.datamodel.SudokuBoard;

public interface BoardService {
	SudokuBoard constructSudokuBoard(List<String> rows);
}
