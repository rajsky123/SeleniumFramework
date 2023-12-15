package com.seleniumhq.selenium_java.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public static List<HashMap<String, String>> getJsonToMap() throws IOException {
		
		String json=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//com//seleniumhq//selenium_java//data//dataProvider.json"),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;
	}

}
