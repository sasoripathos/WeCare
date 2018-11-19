package com.newcomer.fileprocessor.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newcomer.dbservice.MockFileRepository;
import com.newcomer.entity.MockFile;
import com.newcomer.fileprocessor.ValueTranslator;

@Service("MockTemp")
public class MockLoader implements TemplateLoader {
	
	@Autowired
	private MockFileRepository repo;
	
	@Autowired
	private ValueTranslator trans;

	@Override
	public int getTemplateColumnNumber() {
		return 3;
	}

	@Override
	public void load(List<String> row) {
		MockFile data = new MockFile();
		data.setCola(row.get(0));
		data.setColb(row.get(1));
		data.setColc(trans.toBool(row.get(2)));
		repo.save(data);
	}

}
