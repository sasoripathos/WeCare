package com.newcomer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="mockfile")
public class MockFile {
	
	@Id
	private String id;
	
	private String cola;
	
	private String colb;
	
	private Boolean colc;

	public MockFile() {
		
	}
	
	public MockFile(String id, String cola, String colb, Boolean colc) {
		this.id = id;
		this.cola = cola;
		this.colb = colb;
		this.colc = colc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	public String getColb() {
		return colb;
	}

	public void setColb(String colb) {
		this.colb = colb;
	}

	public Boolean getColc() {
		return colc;
	}

	public void setColc(Boolean colc) {
		this.colc = colc;
	}
	
}
