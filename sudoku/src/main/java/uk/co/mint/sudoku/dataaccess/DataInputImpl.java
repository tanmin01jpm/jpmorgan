package uk.co.mint.sudoku.dataaccess;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public final class DataInputImpl implements DataInput {
		
	private File input;	
	public DataInputImpl(File input) {
		this.input = input;
	}

	public List<String> getRows () throws IOException {
		return Files.readAllLines(input.toPath(), Charset.defaultCharset());
	}
}
