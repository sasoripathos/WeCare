package com.newcomer.fileprocessor.checker;

import java.util.List;

public interface TemplateChecker {
	public List<CellError> check(int rowNum, List<String> row);
}
