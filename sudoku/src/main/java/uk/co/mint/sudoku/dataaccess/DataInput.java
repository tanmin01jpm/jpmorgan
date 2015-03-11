package uk.co.mint.sudoku.dataaccess;

import java.io.IOException;
import java.util.List;

public interface DataInput {
	public List<String> getRows() throws IOException;
}
