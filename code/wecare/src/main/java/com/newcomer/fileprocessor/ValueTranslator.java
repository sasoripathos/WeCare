package com.newcomer.fileprocessor;

public class ValueTranslator {
	public static boolean toBool(String value) {
		if(value.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}
}
