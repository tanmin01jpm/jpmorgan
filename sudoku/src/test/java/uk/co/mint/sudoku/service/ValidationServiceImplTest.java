package uk.co.mint.sudoku.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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
import uk.co.mint.sudoku.datamodel.SudokuBoard;
import uk.co.mint.sudoku.datamodel.ValidationType;

@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceImplTest {

		@Mock
		private SudokuBoard  sudokuBoard;

		@Mock
		private Area area;
		
		@InjectMocks
		private ValidationServiceImpl testedSubject;

		@Before
		public void initMocks() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void testValidSolution() {
			when(sudokuBoard.getAreas(any(ValidationType.class))).thenReturn(new LinkedList<Area>());
			Map<ValidationType,List<Area>> map = testedSubject.validate();
			assertTrue(map.get(ValidationType.COLUMN).size()==0);
			assertTrue(map.get(ValidationType.ROW).size()==0);
			assertTrue(map.get(ValidationType.SQUARE).size()==0);
		}
		
		@Test
		public void testInValidSolution() {
			List<Area> errors = Collections.singletonList(area);
			when(sudokuBoard.getAreas(any(ValidationType.class))).thenReturn(errors);
			List<Integer> cells = new LinkedList<Integer>();
			cells.add(1); 
			cells.add(1);
			when(area.getCells()).thenReturn(cells);
			Map<ValidationType,List<Area>> map = testedSubject.validate();
			assertTrue(map.get(ValidationType.COLUMN).size()==1);
			assertTrue(map.get(ValidationType.ROW).size()==1);
			assertTrue(map.get(ValidationType.SQUARE).size()==1);
		}
}
