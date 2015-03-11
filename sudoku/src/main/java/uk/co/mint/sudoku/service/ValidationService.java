package uk.co.mint.sudoku.service;

import java.util.List;
import java.util.Map;

import uk.co.mint.sudoku.datamodel.Area;
import uk.co.mint.sudoku.datamodel.ValidationType;

public interface ValidationService {
    Map<ValidationType,List<Area>> validate();
}
