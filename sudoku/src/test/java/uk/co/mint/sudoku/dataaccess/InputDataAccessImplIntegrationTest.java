package uk.co.mint.sudoku.dataaccess;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import junit.framework.TestCase;

public class InputDataAccessImplIntegrationTest extends TestCase {
	
	@Test
	public void testReadFile() throws IOException {
		File file = new File(getClass().getResource("/invalid.txt").getFile());
		DataInputImpl tested = new DataInputImpl(file);
		assertTrue(tested.getRows().size()==9);
		assertTrue(tested.getRows().get(0).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(1).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(2).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(3).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(4).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(5).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(6).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(7).equals("1,2,3,4,5,6,7,8,9"));
		assertTrue(tested.getRows().get(8).equals("1,2,3,4,5,6,7,8,9"));
	}
}
