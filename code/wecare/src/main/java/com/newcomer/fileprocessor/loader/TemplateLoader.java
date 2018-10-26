package com.newcomer.fileprocessor.loader;

import java.util.List;

public interface TemplateLoader {
	public String getTemplateType();
	public int getTemplateColumnNumber();
	public void load(List<String> row);
}
