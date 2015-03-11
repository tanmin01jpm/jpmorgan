package uk.co.mint.sudoku.clientview;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.mint.sudoku.datamodel.Area;
import uk.co.mint.sudoku.datamodel.ValidationType;

@RunWith(MockitoJUnitRunner.class)
public class ValidationReportTest {

	@Mock
	private Map<ValidationType, List<Area>> reportDate;

	@Mock
	private Area area;
	
	@InjectMocks
	private ValidationReport testedSubject;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidSolution() {
		when(reportDate.get(any(ValidationType.class))).thenReturn(new LinkedList<Area>());
		String result = testedSubject.dipslayValidation(reportDate);
		assertTrue(result.contains("Error code 0 Valid."));
	}
	
	@Test
	public void testInValidSolution() {
		List<Area> errors = Collections.singletonList(area);
		when(reportDate.get(any(ValidationType.class))).thenReturn(errors);
		String result = testedSubject.dipslayValidation(reportDate);
		assertTrue(result.contains("Error code 3 Invalid."));
	}
	
	@Test
	public void testMainInvalidSolution() throws IOException {
		ValidationReport.main(null);
	}
	
	@Test
	public void testMainValidSolution() throws IOException {
		final String[] args= {ValidationReport.class.getResource("/valid.txt").getPath()};
		ValidationReport.main(args);
	}
	
	@Test(expected=java.nio.file.NoSuchFileException.class)
	public void testInputFileNotFoundException() throws IOException {
		final String[] args= {"/filenotexists.txt"};
		ValidationReport.main(args);
	}
}
