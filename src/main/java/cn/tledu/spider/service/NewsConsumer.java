package cn.tledu.spider.service;

import cn.tledu.spider.pojo.SinaNewsPojo;
import cn.tledu.util.MySynQueue;

public class NewsConsumer implements Runnable {
	private MySynQueue<SinaNewsPojo> queue;

	public NewsConsumer(MySynQueue<SinaNewsPojo> queue) {
		super();
		this.queue = queue;
	}
	public void run(){
		Thread ct = Thread.currentThread();
		while (!ct.isInterrupted()) {//优雅轮询
			try {
				int size = queue.size();
				if (size > 0) {
					SinaNewsPojo pojo = queue.poll();
					String liUrlStr = pojo.getUrlStr();
					String liTitle = pojo.getTitle();
					String liDate = pojo.getDateStr();
					SinaNewsSpider.detailProcessor(liUrlStr, liTitle, liDate);
					long sec = 1L;
					System.out.println("详情页爬取完成, 休息"+sec+"秒后继续");
					Thread.sleep(sec * 1000L);
				} else {
					long sec = 3L;
					System.out.println("队列为空, 休息"+sec+"秒后继续");
					Thread.sleep(sec * 1000L);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
