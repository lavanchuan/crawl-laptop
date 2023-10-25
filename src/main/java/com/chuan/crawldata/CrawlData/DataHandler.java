package com.chuan.crawldata.CrawlData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
	
	public static final String TXT_LAPTOP = "laptop_dp.txt";
	public static final String TXT_LAPTOP_TYPES = "laptop_types.txt";
	
	public static void save(String filePath, StringBuffer content) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("res/"+filePath));
			bw.write(content.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) bw = null;
		}
	}
	
	public static List<String> loadTypeDB(){
		List<String> data = new ArrayList<>();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("res/"+TXT_LAPTOP_TYPES));
			String line;
			while((line = br.readLine()) != null){
				data.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) br = null;
		}
		
		
		return data;
	}
}
