package com.newcomer.fileprocessor;

import org.springframework.stereotype.Service;

/**
 * This class is a stateless service (singleton) which translate a value to a specific type.
 *
 * This translator provides some error tolerances for input data.
 */

@Service
public class ValueTranslator {
	/**
	 * Given a piece of row data value, if value means yes, convert it into true. Any other
	 * input will be converted to false.
	 * 
	 * @param value a string representing row data.
	 * @return a boolean value after translation.
	 */
	public boolean toBool(String value) {
		if(value.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}
}
