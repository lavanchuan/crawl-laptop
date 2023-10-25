package com.chuan.crawldata.CrawlData;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaptopTypeCrawler {
	
	public static final Logger log = LoggerFactory.getLogger(LaptopTypeCrawler.class);
	
	public static StringBuffer laptopTypes() {
		StringBuffer data = new StringBuffer();
		try {
			Document doc = Jsoup.connect("https://www.thegioididong.com/laptop-ldp").get();
			
			Elements types = doc.select(".quick-link a");
			for(Element e : types) {
				data.append(e.attr("href")+"\n");
			}
			
			log.info("chuan.success ==>> crawl success!!!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.info("chuan.error ==>> crawl error!!!");
			e.printStackTrace();
		}
		return data;
	}
}
