package com.newcomer.fileprocessor.checker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcomer.config.NeedAssessRefCheckerConfig;

/**
 * This class is a stateless service (singleton) which checks a row of data in the
 * Needs Assessment and Referrals Service template for errors.
 */
@Service("Needs Assessment and Referrals Service Checker")
public class NeedAssessRefChecker extends BaseChecker {
	
	@Autowired
	private NeedAssessRefCheckerConfig config;

	@Override
	public List<CellError> check(int rowNum, List<String> row) {
		List<CellError> ans = checkNotNull(rowNum, row, config.getNotNull());
		return ans;
	}

}
