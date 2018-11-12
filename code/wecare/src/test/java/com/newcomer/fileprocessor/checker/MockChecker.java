package com.newcomer.fileprocessor.checker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("MockTemp Checker")
public class MockChecker implements TemplateChecker {

	@Override
	public List<CellError> check(int rowNum, List<String> row) {
		List<CellError> error = new ArrayList<CellError>();
		if(row.get(1).equals("")) {
			error.add(new CellError(rowNum, 1, CellError.nullError));
		}
		return error;
	}

}
