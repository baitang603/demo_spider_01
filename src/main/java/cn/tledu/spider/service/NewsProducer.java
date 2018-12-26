package cn.tledu.spider.service;

import cn.tledu.spider.pojo.SinaNewsPojo;
import cn.tledu.util.MySynQueue;

public class NewsProducer implements Runnable {
	private String urlStr;
	private String encoding;
	private MySynQueue<SinaNewsPojo> queue;

	public NewsProducer(String urlStr, String encoding,
			MySynQueue<SinaNewsPojo> queue) {
		super();
		this.urlStr = urlStr;
		this.encoding = encoding;
		this.queue = queue;
	}

	public void run() {
		System.out.println("开始爬取列表页...");
		SinaNewsSpider.crawler(urlStr, encoding, queue);
		System.out.println("爬取列表页完成");
	}

}
