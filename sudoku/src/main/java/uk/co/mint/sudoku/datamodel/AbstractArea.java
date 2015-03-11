package uk.co.mint.sudoku.datamodel;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractArea implements Area {

	private List<Integer> cells = new LinkedList<Integer>();
	public List<Integer> getCells() {
		return this.cells;
	}
}
