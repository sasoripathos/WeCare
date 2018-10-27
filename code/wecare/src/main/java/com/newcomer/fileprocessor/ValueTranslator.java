package com.newcomer.fileprocessor;

import org.springframework.stereotype.Service;

@Service
public class ValueTranslator {
	public boolean toBool(String value) {
		if(value.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}
}
