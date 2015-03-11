package uk.co.mint.sudoku.clientview;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import uk.co.mint.sudoku.dataaccess.DataInput;
import uk.co.mint.sudoku.dataaccess.DataInputImpl;
import uk.co.mint.sudoku.datamodel.Area;
import uk.co.mint.sudoku.datamodel.SudokuBoard;
import uk.co.mint.sudoku.datamodel.ValidationType;
import uk.co.mint.sudoku.service.BoardService;
import uk.co.mint.sudoku.service.BoardServiceImpl;
import uk.co.mint.sudoku.service.ValidationService;
import uk.co.mint.sudoku.service.ValidationServiceImpl;

final public class ValidationReport {

	public String dipslayValidation(Map<ValidationType, List<Area>> reportData) {
		int errorCode = 0;
		final StringBuilder stringBuilder = new StringBuilder();
		for (ValidationType validationType : ValidationType.values()) {
			final List<Area> errors = reportData.get(validationType);
			stringBuilder.append(validationType.getDescription() + " has "
					+ errors.size() + " failures.");
			stringBuilder.append("\n");
			
			for(Area error:errors) {
				stringBuilder.append(error.getCells());
				stringBuilder.append("\n");
			}			
			errorCode = errorCode+errors.size();
		}
		
		stringBuilder.append("Error code " + errorCode);
		stringBuilder.append(" " + ((errorCode>0)? "Invalid.":"Valid."));
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws IOException {
		ValidationReport validationReport = new ValidationReport();
		File input = validationReport.findInputFile(args);
		List<String> rows = validationReport.getRows(input);
		SudokuBoard sudokuBoard = validationReport.constructBoard(rows);
		ValidationService validationService = new ValidationServiceImpl(sudokuBoard);
		System.out.println(validationReport.dipslayValidation(validationService.validate()));
	}
	
	private SudokuBoard constructBoard(List<String> rows) {
		BoardService boardService = new BoardServiceImpl();
		return boardService.constructSudokuBoard(rows);
	}

	private List<String> getRows(File input) throws IOException {
		DataInput inputDataAccess = new DataInputImpl(input);
		return inputDataAccess.getRows();
	}

	private File findInputFile(String[] args) {
		System.out.println(Arrays.deepToString(args));
		File input = null;
		if (args == null) {
			input = new File(ValidationReport.class.getResource("/invalid.txt")
					.getFile());
		} else {
			input = new File(args[0]);
		}
		return input;
	}
}
