package com.newcomer.fileprocessor.loader;

import java.util.List;

public interface TemplateLoader {
	public int getTemplateColumnNumber();
	public void load(List<String> row);
}
