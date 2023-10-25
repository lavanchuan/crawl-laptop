package com.chuan.crawldata.CrawlData;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaptopDataCrawler {
	
	public static final String parent = "||";
	
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
	
	public static StringBuffer loadLaptopDB() {
		StringBuffer data = new StringBuffer();
		
		try {
			Document doc;
			StringBuffer ltInfo = new StringBuffer();
			String line;
			
			int i = 0;
			for(String type : DataHandler.loadTypeDB()) {
				doc = Jsoup.connect(CrawlHandler.topDomain + type).get();
				if(++i > 1) break;
				Elements laptops = doc.select(".listproduct li");
				for(Element e : laptops) {
					ltInfo = new StringBuffer();
					line = type + parent +
							e.select("h3").text() + parent +
							e.select("strong").text() + parent +
//							e.select("img").get(0).attr("data-src") + parent +
//							e.select("span").get(1).text() + parent +
//							e.select("span").get(2).text() + parent +
//							e.select("p").get(2).text() + parent +
//							e.select("p").get(3).text() + parent +
//							e.select("p").get(4).text() + parent +
//							e.select("p").get(5).text() + parent +
//							e.select("p").get(6).text() +
							"\n";
							
					
					ltInfo.append(line+"\n");
					
					log.info("chuan.test-laptop ==>> " + line);
				}
				data.append(ltInfo.toString());
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
