package com.chuan.crawldata.CrawlData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrawlHandler {
	
	public static final String topDomain = "https://www.thegioididong.com/";
	
	@Bean
	CommandLineRunner initLaptopData() {
		return arsg->{
			DataHandler.save(DataHandler.TXT_LAPTOP_TYPES, LaptopTypeCrawler.laptopTypes());
			DataHandler.save(DataHandler.TXT_LAPTOP, LaptopDataCrawler.loadLaptopDB());
			
		};
	}
}
