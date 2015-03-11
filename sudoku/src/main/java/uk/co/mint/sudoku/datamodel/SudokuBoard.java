package uk.co.mint.sudoku.datamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuBoard {

	public final static int AREA_SIZE = 9;
	public final static int SQUARE_SIDE_SIZE = 3;
	
	private Map<ValidationType,List<Area>> layouts = new HashMap<ValidationType,List<Area>>(ValidationType.values().length);

	public SudokuBoard(List<Area> rows, List<Area> columns, List<Area> squares) {
		layouts.put(ValidationType.ROW, rows);
		layouts.put(ValidationType.COLUMN, columns);
		layouts.put(ValidationType.SQUARE, squares);
	}

	public List<Area> getAreas(ValidationType type) {
		return layouts.get(type);
	}
	
	
}
