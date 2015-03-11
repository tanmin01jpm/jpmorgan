package uk.co.mint.sudoku.datamodel;

public enum ValidationType {

	ROW("Validation by rows"), COLUMN("Validation by column"), SQUARE(
			"Validation by square area");

	private final String description;

	ValidationType(String d) {
		this.description = d;
	}

	public String getDescription() {
		return this.description;
	}
}
