package com.newcomer.fileprocessor.checker;

import java.util.List;

/**
 * This class is a stateless service (singleton) which checks a row of data in the
 * given template for errors.
 */
public interface TemplateChecker {
	/**
	 * Taking in a row of data in a template and the row number of that row, check for all
	 * possible errors exist in the row.
	 */
	public List<CellError> check(int rowNum, List<String> row);
}
