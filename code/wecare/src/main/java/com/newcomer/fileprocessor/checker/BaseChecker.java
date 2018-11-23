package com.newcomer.fileprocessor.checker;

import java.util.ArrayList;
import java.util.List;

/**
 * The (abstract) base checker which provides all checking templates for all possible errors.
 */

public abstract class BaseChecker implements TemplateChecker {
	
	/**
	 * Check whether the required columns (cols) of the given row are null. Return the list of
	 * error messages for those columns whose value is null.
	 * 
	 * @param rowNum the row index of the given row, starting from 0.
	 * @param row a row of data.
	 * @param cols the list of column index of the required columns, starting from 0.
	 * @return the list of error messages for those columns whose value is null.
	 */
	protected List<CellError> checkNotNull(int rowNum, List<String> row, List<Integer> cols) {
		List<CellError> ans = new ArrayList<CellError>();
		for (int i:cols) {
			if(row.get(i).equals("")) {
				ans.add(new CellError(rowNum, i, CellError.nullError));
			}
		}
		return ans;
	}

	@Override
	public abstract List<CellError> check(int rowNum, List<String> row);

}
