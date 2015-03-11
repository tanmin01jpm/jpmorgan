package uk.co.mint.sudoku.service;

import java.util.ArrayList;
import java.util.List;

import uk.co.mint.sudoku.datamodel.Area;
import uk.co.mint.sudoku.datamodel.RectangularArea;
import uk.co.mint.sudoku.datamodel.SquareArea;
import uk.co.mint.sudoku.datamodel.SudokuBoard;

final public class BoardServiceImpl implements BoardService {
	  private final static String CELL_SEPERATOR = ",";
	  
	  private final List<Area> rows = new ArrayList<Area>(SudokuBoard.AREA_SIZE);
	  private final List<Area> columns = new ArrayList<Area>(SudokuBoard.AREA_SIZE);
	  private final List<Area> squares = new ArrayList<Area>(SudokuBoard.AREA_SIZE);;

	  public BoardServiceImpl() {
		for(int i=0;i<SudokuBoard.AREA_SIZE; i++) {
			rows.add(i, new RectangularArea());
			columns.add(i, new RectangularArea());
			squares.add(i, new SquareArea());
		}
	  }
	  
      public SudokuBoard constructSudokuBoard (List<String> lines) { 	
    	  for(int i=0; i<SudokuBoard.AREA_SIZE; i++) {
    		  String[] cells = lines.get(i).split(CELL_SEPERATOR);
    		  for(int j=0;j<SudokuBoard.AREA_SIZE;j++) {
    			  constructAreas(cells[j], i, j);
    		  }
    	  }
    	  return new SudokuBoard(rows,columns,squares);
      }
      
      private void constructAreas(String input, int row, int column) {
    	  Integer cell = Integer.valueOf(input);
		  this.rows.get(row).getCells().add(cell);
		  this.columns.get(column).getCells().add(cell);  
		  int squareAreaId = generateSquareAreaId(row,column);
		  this.squares.get(squareAreaId).getCells().add(cell);
      }
      
      private int generateSquareAreaId(int row, int column) {
    	 int x = column/SudokuBoard.SQUARE_SIDE_SIZE;
    	 int y = row/SudokuBoard.SQUARE_SIDE_SIZE;
    	 int id = x + y*SudokuBoard.SQUARE_SIDE_SIZE;
    	 return id;
      }
}
