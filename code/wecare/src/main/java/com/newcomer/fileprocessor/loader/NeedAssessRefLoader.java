package com.newcomer.fileprocessor.loader;

import java.util.List;

public class NeedAssessRefLoader implements TemplateLoader {

	@Override
	public String getTemplateType() {
		return "Needs Assessment and Referrals Service";
	}

	@Override
	public void load(List<String> row) {

	}

	@Override
	public int getTemplateColumnNumber() {
		return 92;
	}

}
