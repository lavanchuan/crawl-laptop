package com.chuan.crawldata.CrawlData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlLaptopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlLaptopApplication.class, args);
		
		// test
		StringBuffer sb = new StringBuffer();
		sb.append("lavanchuan");
		DataHandler.save(DataHandler.TXT_LAPTOP, sb);
	}

}
