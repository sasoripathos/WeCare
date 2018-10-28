package com.newcomer.fileprocessor.checker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcomer.config.NeedAssessRefCheckerConfig;

@Service("Needs Assessment and Referrals Service Checker")
public class NeedAssessRefChecker implements TemplateChecker {
	
	@Autowired
	private NeedAssessRefCheckerConfig config;

	private List<CellError> checkNotNull(int rowNum, List<String> row) {
		List<Integer> cols = config.getNotNull();
		List<CellError> ans = new ArrayList<CellError>();
		for (int i:cols) {
			if(row.get(i).equals("")) {
				ans.add(new CellError(rowNum, i, CellError.nullError));
			}
		}
		return ans;
	}

	@Override
	public List<CellError> check(int rowNum, List<String> row) {
		List<CellError> ans = checkNotNull(rowNum, row);
		return ans;
	}

}
