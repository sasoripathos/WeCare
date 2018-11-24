package com.newcomer.fileprocessor.loader;

import java.util.List;

/**
 * This class is a stateless service (singleton) which takes a row of data in the
 * given template and save it to corresponding database tables/collections.
 */
public interface TemplateLoader {
	/**
	 * Get the index of the last column where has data in the given template.
	 * @return the index of the last column where has data.
	 */
	public int getTemplateColumnNumber();
	
	/**
	 * Given a row of data in the given template, save it to corresponding database
	 * tables/collections.
	 * @param row a row of data in the given template.
	 */
	public void load(List<String> row);
}
