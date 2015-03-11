package uk.co.mint.sudoku.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uk.co.mint.sudoku.datamodel.Area;
import uk.co.mint.sudoku.datamodel.SudokuBoard;
import uk.co.mint.sudoku.datamodel.ValidationType;

public final class ValidationServiceImpl implements ValidationService {

	private SudokuBoard sudokuBoard;

	public ValidationServiceImpl(SudokuBoard sudokuBoard) {
		this.sudokuBoard = sudokuBoard;
	}

	private boolean validateArea(final Area area) {
		Set<Integer> set = new HashSet<Integer>(area.getCells());
		return set.size() == area.getCells().size();
	}

	public Map<ValidationType, List<Area>> validate() {
		Map<ValidationType, List<Area>> result = new HashMap<ValidationType, List<Area>>(
				ValidationType.values().length);

		for (ValidationType type : ValidationType.values()) {
			result.put(type, findInvalidAreas(type));
		}

		return result;
	}

	private List<Area> findInvalidAreas(ValidationType type) {
		List<Area> invalidAreas = new LinkedList<Area>();

		for (Area area : this.sudokuBoard.getAreas(type)) {
			if (!validateArea(area)) {
				invalidAreas.add(area);
			}
		}

		return invalidAreas;
	}
}