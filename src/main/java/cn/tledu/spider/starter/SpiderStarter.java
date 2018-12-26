package cn.tledu.spider.starter;

import cn.tledu.spider.service.SinaNewsSpider;

public class SpiderStarter {

	public static void main(String[] args) {
//		SinaNewsSpider.crawler();
//		System.out.println("done");
		
		SinaNewsSpider.multiThreadCrawler();
	}

}
